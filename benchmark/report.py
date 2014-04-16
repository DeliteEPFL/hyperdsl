#!/usr/bin/env python
from __future__ import print_function, division

import sys
import os
import argparse
import subprocess
import time
import json

import config


def main():
  parser = argparse.ArgumentParser(description="Generate performance reports for Delite apps.")
  parser.add_argument("-v", "--verbose", action="store_true")
  parser.add_argument("-b", "--bars", type=int, default="3", 
    help="number of bars to display in version comparison plots")
  app_c_group = parser.add_mutually_exclusive_group()
  app_c_group.add_argument("-a", "--app-comparison", type=str, nargs="*", default=[],
    help="comma-separated list of apps to generate an app comparison plot for")
  app_c_group.add_argument("-A", "--app-comparison-default", action="store_true",
    help="use default apps for app comparison")
  ver_c_group = parser.add_mutually_exclusive_group()
  ver_c_group.add_argument("-c", "--ver-comparison", type=str, nargs="*", default=[],
    help="app to generate version comparison plot for")
  ver_c_group.add_argument("-C", "--ver-comparison-default", action="store_true",
    help="use default apps for version comparison")

  args = parser.parse_args()

  # collect the apps to analyze
  ac_apps_arg = args.app_comparison
  if (args.app_comparison_default):
    ac_apps_arg = config.default_apps
  vc_apps_arg = args.ver_comparison
  if (args.ver_comparison_default):
    vc_apps_arg = config.default_comparison_plots
  vc_apps = []
  for a in vc_apps_arg:
    if(a not in config.apps):
      print("error: app {0} not found in config file".format(a), file=sys.stderr)
      exit(-1)
    vc_apps.append(config.apps[a])
    if(args.verbose):
      print("notice: identified version-comparison app {0}".format(config.apps[a].name), file=sys.stderr)
  ac_apps = []
  for c in ac_apps_arg:
    ac = []
    for a in c.split(","):
      if(a not in config.apps):
        print("error: app {0} not found in config file".format(a), file=sys.stderr)
        exit(-1)
      ac.append(config.apps[a])
    ac_apps.append(ac)
    if(args.verbose):
      print("notice: identified app-comparison {0}".format(",".join(a.name for a in ac)), file=sys.stderr)

  exit(0)

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
  subprocess.check_call("rm -f benchmark/times/latest", shell=True)
  subprocess.check_call("mkdir -p benchmark/times/{0}".format(git_hash), shell=True)
  subprocess.check_call("ln -s {0} benchmark/times/latest".format(git_hash), shell=True)

  if(args.verbose):
    print("notice: publishing forge dsls", file=sys.stderr)
  for dsl in config.dsls:
    if dsl.needs_publish:
      if(args.verbose):
        print("notice: publishing {0}".format(dsl.name), file=sys.stderr)
      subprocess.check_call(dsl.publish_command, stdout=sys.stderr, stderr=sys.stderr, shell=True)

  delite_options = "-r {0}".format(args.runs)
  if(args.verbose):
    delite_options += " -v"

  if(args.verbose):
    print("notice: running apps", file=sys.stderr)
  for app in config.apps:
    if(args.verbose):
      print("notice: staging {0}".format(app.name), file=sys.stderr)
    os.chdir(app.dsl.run_dir)
    subprocess.call(app.stage_command(), 
      stdout=open(hyperdsl_root + "/benchmark/times/{0}/{1}.delitec.out".format(git_hash, app.name), "w"), 
      stderr=open(hyperdsl_root + "/benchmark/times/{0}/{1}.delitec.err".format(git_hash, app.name), "w"), 
      shell=True)
    for c in app.configs:
      if(args.verbose):
        print("notice: running {0} under configuration {1}".format(app.name, c.name))
      opts = " -Dstats.dump -Dstats.dump.component=app -Dstats.dump.overwrite -Dstats.output.dir={0} -Dstats.output.filename={1}-{2}.times {3}".format(
        hyperdsl_root + "/benchmark/times/" + git_hash, app.name, c.name, os.getenv("JAVA_OPTS", ""))
      os.putenv("JAVA_OPTS", opts)
      subprocess.call(app.run_command(c, delite_options), 
        stdout=open(hyperdsl_root + "/benchmark/times/{0}/{1}-{2}.delite.out".format(git_hash, app.name, c.name), "w"), 
        stderr=open(hyperdsl_root + "/benchmark/times/{0}/{1}-{2}.delite.err".format(git_hash, app.name, c.name), "w"), 
        shell=True)
    os.chdir(hyperdsl_root)

  if(args.skip_report):
    return 0

  # identify the most recent timed hashes
  if(args.verbose):
    print("notice: searching for previous times", file=sys.stderr)
  report_hashes = []
  git_log = subprocess.check_output("git log --pretty=format:%h", shell=True).strip().split("\n")
  for gh in git_log:
    if(os.path.isdir("benchmark/times/" + gh)):
      if(args.verbose):
        print("notice: identified timed hash " + gh, file=sys.sterrr)
      report_hashes.append(gh)
      if(len(report_hashes) >= args.bars):
        break
  else:
    if(args.verbose):
      print("notice: ran out of previous hashes", file=sys.sterrr)

  if(git_hash not in report_hashes):
    print("error: couldn't find data for the runs we just did")

  # load data for all hashes
  report_data = [loadData(h, args.verbose) for h in report_hashes]

  # generate the plots
  plot_data = []
  for app in config.apps:
    vc_plot = {}
    vc_plot["title"] = "{0}/{1} Performance Comparison".format(app.dsl.name, app.name)
    vc_plot["data"] = []
    for c in app.configs:
      cc_data = {}
      cc_data["Configuration"] = c.name
      for (h, d) in zip(report_hashes, report_data):
        cc_data[h] = "{0:.4f}".format(d[app.name + "/" + c.name])
      vc_plot["data"].append(cc_data)
    plot_data.append(vc_plot)

  for aa in config.app_comparison_plots:
    vc_plot = {}
    vc_plot["title"] = "{0} Performance Comparison".format(" vs ".join(a.name for a in aa))
    vc_plot["data"] = []
    for c in app.configs:
      cc_data = {}
      cc_data["Configuration"] = c.name
      for a in aa:
        cc_data[a.name] = "{0:.4f}".format(report_data[0][a.name + "/" + c.name])
      vc_plot["data"].append(cc_data)
    plot_data.append(vc_plot)

  # write out the report
  with open("benchmark/times/{0}/report.html".format(git_hash), "w") as freport:
    # write the report head
    print(report_head.format(git_hash), file=freport)
    # write the report title
    print("  <h1>Performance Comparison for Commit [{0}]</h1>".format(git_hash), file=freport)
    print("  <p>Plots generated at {0}.</p>".format(time.strftime("%c")), file=freport)
    # write out the plots
    print("  <script>", file=freport)
    print("    document.plotData = " + json.dumps(plot_data) + ";", file=freport)
    print("  </script>", file=freport)
    # and close the tags
    print("</body>", file=freport)
    print("</html>", file=freport)


def loadData(git_hash, verbose):
  if(verbose):
    print("notice: loading data for hash " + git_hash, file=sys.stderr)
  rv = {}
  for app in config.apps:
    for c in app.configs:
      cafn = "benchmark/times/{0}/{1}-{2}.times".format(git_hash, app.name, c.name)
      if(os.path.isfile(cafn)):
        with open(cafn, "r") as f:
          catimes = f.read().strip().split("\n")
          # discard the first half of the entries
          catimes = catimes[(len(catimes) // 2):]         
          rv[app.name + "/" + c.name] = sum(float(t)*1e-6 for t in catimes)/len(catimes)
      else:
        rv[app.name + "/" + c.name] = 0
  return rv



report_head = """<!DOCTYPE html>
<html>
<head>
  <title>[{0}] Performance Comparison</title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="http://arsenalfc.stanford.edu/kogroup/benchmark/benchmark.css">
  <script src="http://d3js.org/d3.v3.min.js"></script>
  <script src="http://arsenalfc.stanford.edu/kogroup/benchmark/d3-tip.js"></script>
  <script src="http://arsenalfc.stanford.edu/kogroup/benchmark/benchmark.js"></script>
</head>
<body>"""


if __name__ == "__main__":
  main()
