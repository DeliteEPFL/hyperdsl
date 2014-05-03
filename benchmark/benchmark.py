#!/usr/bin/env python
from __future__ import print_function, division

import sys
import os
import argparse
import subprocess
import time
import json
import socket

import util
import config


def main():
  parser = argparse.ArgumentParser(description="Gather performance numbers for Delite apps.")
  parser.add_argument("-v", "--verbose", action="store_true")
  parser.add_argument("-f", "--force", action="store_true",
    help="force execution even if the git repository contains uncommitted changes")
  parser.add_argument("-r", "--runs", type=int, default="5",
    help="number of times to run the apps")
  parser.add_argument("-p", "--filtered-runs", type=int, default="2",
    help="filter the first this many runs")
  parser.add_argument("-d", "--directory", type=str, default="/kunle/ppl/delite/benchmark/times",
    help="directory to write the raw output into")
  parser.add_argument("-j", "--json-directory", type=str, default="/kunle/ppl/delite/benchmark/json",
    help="directory to write the json output into")
  parser.add_argument("apps", type=str, nargs="*", default=config.default_apps, help="apps to run")

  args = parser.parse_args()

  # collect the apps to run
  apps = []
  dsls = []
  for a in args.apps:
    if (a not in config.apps):
      print("error: app {0} not found in config file".format(a), file=sys.stderr)
      exit(-1)
    app = config.apps[a]
    if(app.dsl not in dsls):
      dsls.append(app.dsl)
      if(args.verbose):
        print("notice: identified dsl {0}".format(app.dsl.name))
    apps.append(app)
    if(args.verbose):
      print("notice: identified app {0}".format(app.name))

  # chdir to the hyperdsl root directory
  hyperdsl_root = util.chdir_hyperdsl_root()

  # check that there are no changes to the repository
  git_status = subprocess.check_output("git status -s", shell=True)
  if((not args.force) and (git_status != "")):
    print("error: hyperdsl repository contains uncommitted changes", file=sys.stderr)
    print("       commit these changes before running benchmark.py", file=sys.stderr)
    exit(-1)

  # identify the hash associated with the current branch
  git_hash = subprocess.check_output("git rev-parse --short HEAD", shell=True).strip()
  if(args.verbose):
    print("notice: identified git hash {0}".format(git_hash), file=sys.stderr)

  if(args.verbose):
    print("notice: creating directory for experimental results", file=sys.stderr)
  subprocess.check_call("rm -f {0}/latest".format(args.directory), shell=True)
  subprocess.check_call("mkdir -p {0}/{1}".format(args.directory, git_hash), shell=True)
  subprocess.check_call("ln -s {0} {1}/latest".format(git_hash, args.directory), shell=True)

  output_json = {}
  output_json["git_hash"] = git_hash
  output_json["start_time"] = time.time()
  output_json["host"] = socket.gethostname()
  output_json["dsls"] = {}
  output_json["apps"] = {}

  if(args.verbose):
    print("notice: publishing forge dsls", file=sys.stderr)
  for dsl in dsls:
    if dsl.needs_publish:
      if(args.verbose):
        print("notice: publishing {0}".format(dsl.name), file=sys.stderr)
      output_json["dsls"][dsl.name] = json_call(dsl.publish_command, "{0}/{1}/{2}.publish".format(args.directory, git_hash, dsl.name))

  if(args.verbose):
    print("notice: running apps", file=sys.stderr)
  for app in apps:
    output_json["apps"][app.name] = {}
    if(args.verbose):
      print("notice: staging {0}".format(app.name), file=sys.stderr)
    os.chdir(app.dsl.run_dir)
    output_json["apps"][app.name]["stage"] = json_call(app.stage_command(), "{0}/{1}/{2}.delitec".format(args.directory, git_hash, app.name))
    output_json["apps"][app.name]["configs"] = {}
    for c in app.configs:
      if(args.verbose):
        print("notice: running {0} under configuration {1}".format(app.name, c.name))
      opts = " -Dstats.dump -Dstats.dump.component=app -Dstats.dump.overwrite -Dstats.output.dir={0}/{1} -Dstats.output.filename={2}-{3}.times {4}".format(
        args.directory, git_hash, app.name, c.name, os.getenv("JAVA_OPTS", ""))
      os.putenv("JAVA_OPTS", opts)
      output_json["apps"][app.name]["configs"][c.name] = json_call(app.run_command(c, args.runs, args.verbose),
        "{0}/{1}/{2}-{3}.delite".format(args.directory, git_hash, app.name, c.name))
      output_json["apps"][app.name]["configs"][c.name]["opts"] = opts
      cafn = "{0}/{1}/{2}-{3}.times".format(args.directory, git_hash, app.name, c.name)
      if(os.path.isfile(cafn)):
        with open(cafn, "r") as ftimes:
          raw_times = [float(t)*1e-6 for t in ftimes.read().strip().split("\n")]
        output_json["apps"][app.name]["configs"][c.name]["raw_times"] = raw_times
        if (c.run_only_once):
          if(len(raw_times) == 1):
            output_json["apps"][app.name]["configs"][c.name]["filtered_times"] = raw_times
            output_json["apps"][app.name]["configs"][c.name]["avg_time"] = raw_times[0]
          else:
            output_json["apps"][app.name]["configs"][c.name]["filtered_times"] = []
            output_json["apps"][app.name]["configs"][c.name]["avg_time"] = 0.0
        else:
          if(len(raw_times) == args.runs):
            filtered_times = raw_times[args.filtered_runs:]
            output_json["apps"][app.name]["configs"][c.name]["filtered_times"] = filtered_times
            output_json["apps"][app.name]["configs"][c.name]["avg_time"] = sum(filtered_times)/(len(filtered_times) + 1e-60)
          else:
            output_json["apps"][app.name]["configs"][c.name]["filtered_times"] = []
            output_json["apps"][app.name]["configs"][c.name]["avg_time"] = 0.0
      else:
        output_json["apps"][app.name]["configs"][c.name]["raw_times"] = []
        output_json["apps"][app.name]["configs"][c.name]["filtered_times"] = []
        output_json["apps"][app.name]["configs"][c.name]["avg_time"] = 0.0
    os.chdir(hyperdsl_root)

  json.dump(output_json, open("{0}/{1}.json".format(args.json_directory, git_hash)))



def json_call(command, file_pfx):
  rv = {}
  rv["command"] = command
  subprocess.call(command, stdout=open(file_pfx + ".out", "w"), stderr=open(file_pfx + ".err", "w"), shell=True)
  rv["out"] = open(file_pfx + ".out").read()
  rv["err"] = open(file_pfx + ".err").read()
  return rv

if __name__ == "__main__":
  main()
