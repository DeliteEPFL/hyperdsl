# functionality common to delite and delitec

import os, sys
import ConfigParser

USER_HOME = os.getenv("HOME")
JAVA_HOME = os.getenv("JAVA_HOME")
SCALA_VIRT_HOME = os.getenv("SCALA_VIRT_HOME")
MESOS_NATIVE_LIBRARY = os.getenv("MESOS_NATIVE_LIBRARY")
DELITE_MEM = os.getenv("DELITE_MEM")

script_path = os.path.dirname(__file__)
script_home = os.path.split(script_path)[0]
DIST_HOME = script_home

scala_virt_prefix = "org.scala-lang.virtualized."
scala_virt_version = "scala-2.10.2-RC1"
scala_major_id = '.'.join(scala_virt_version.split('.')[0:2]) 
#scala_major_id = "scala-2.10.2-RC1" # the full version is needed only when scalaBinaryVersion is set in sbt
props = {}

def err(s):
    exit("error: " + s)

def warn(s):
    print("warn: " + s)
 
def initialize():
    loadProps()
    checkCommonEnv()

def loadProps():
    script_path = os.path.dirname(__file__)
    cand_home = os.path.split(script_path)[0]
    propf = cand_home + "/delite.properties"
    if not os.path.isfile(propf):
        return

    config = ConfigParser.ConfigParser()
    config.readfp(open(propf))
    items = config.items('delite')
    for item in items:
        k, v = item
        props[k] = v


def checkCommonEnv():
    global USER_HOME
    global JAVA_HOME
    global SCALA_VIRT_HOME
    global MESOS_NATIVE_LIBRARY
    global DELITE_MEM

    if JAVA_HOME is None:
        if "java.home" in props:
            JAVA_HOME = props["java.home"]
        else:
            # try to find it
            unix_java = "/usr/lib/jvm/default-java/"
            osx_java = "/Library/Java/Home/"

            if os.path.isdir(unix_java):
                JAVA_HOME = unix_java
            elif os.path.isdir(osx_java):
                JAVA_HOME = osx_java
            else:
                err("The JAVA_HOME environment variable must be defined or the java.home entry in delite.properties must be set.")

    if SCALA_VIRT_HOME is None:
        if "scala.virtualized.home" in props:
            scala_virt_home = props["scala.virtualized.home"]
            if not os.path.isdir(scala_virt_home):
                warn("couldn't find scala virtualized at: " + scala_virt_home)
            else:
                SCALA_VIRT_HOME = scala_virt_home
    
    if SCALA_VIRT_HOME is None:
        scala_virt_home = USER_HOME + "/.sbt/boot/" + scala_virt_prefix + scala_virt_version + "/lib/"
        if not os.path.isdir(scala_virt_home):
            err("couldn't find scala virtualized at: " + scala_virt_home + ". Please set the SCALA_VIRT_HOME environment variable or scala.virtualized.home entry in delite.properties manually.")
        SCALA_VIRT_HOME = scala_virt_home

    if MESOS_NATIVE_LIBRARY is None:
        if "mesos.lib" in props:
            MESOS_NATIVE_LIBRARY = props["mesos.lib"]

    if DELITE_MEM is None:
        if "delite.mem" in props:
            DELITE_MEM = props["delite.mem"]

def printEnv():
  print("======== REQUIRED DELITE ENVIRONMENT VARIABLES =========")
  print("USER_HOME = " + USER_HOME)
  print("JAVA_HOME = " + JAVA_HOME)
  print("SCALA_VIRT_HOME = " + SCALA_VIRT_HOME)


