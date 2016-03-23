

import sbt._
import Keys._
import Tests._

object SimpleVectorBuild extends Build {
  if (System.getProperty("showSuppressedErrors") == null) System.setProperty("showSuppressedErrors", "true")
  val virtScala = "2.11.2"
  val virtBuildSettingsBase = Project.defaultSettings ++ Seq(
    organization := "stanford-ppl",
    scalaOrganization := "org.scala-lang.virtualized",
    scalaVersion := virtScala,

    publishArtifact in (Compile, packageDoc) := false,
    // needed for scala.tools, which is apparently not included in sbt's built in version
    libraryDependencies += "org.scala-lang" % "scala-library" % virtScala,
    libraryDependencies += "org.scala-lang" % "scala-compiler" % virtScala,
    libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.2",
    libraryDependencies += "com.google.guava" % "guava" % "17.0",
    libraryDependencies += "org.apache.commons" % "commons-math" % "2.2",
    libraryDependencies += "commons-io" % "commons-io" % "2.4",
    // cluster deps
    libraryDependencies += "com.google.protobuf" % "protobuf-java" % "2.5.0",
    libraryDependencies += "org.apache.mesos" % "mesos" % "0.20.1",
    libraryDependencies += "org.apache.hadoop" % "hadoop-common" % "2.5.1",
    libraryDependencies += "org.apache.hadoop" % "hadoop-client" % "2.5.1",
    libraryDependencies += "org.apache.hadoop" % "hadoop-hdfs" % "2.5.1",
    // used in delitec to access jars
    retrieveManaged := true,
    scalacOptions += "-Yno-generic-signatures",
    scalacOptions += "-Yvirtualize",
    initialCommands in console += "import simplevector.library._; val SimpleVector = new SimpleVectorREPL { def main() = {} }; import SimpleVector._",
    addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
  )

  val virtBuildSettings = virtBuildSettingsBase ++ Seq(
    scalaSource in Compile <<= baseDirectory(_ / "src")
  )


  lazy val LMS_HOME = sys.env.get("LMS_HOME").getOrElse(error("Please set the LMS_HOME environment variable."))
  lazy val DELITE_HOME = sys.env.get("DELITE_HOME").getOrElse(error("Please set the DELITE_HOME environment variable."))
  lazy val SCALA_RECORDS_HOME = sys.env.get("SCALA_RECORDS_HOME").getOrElse(error("Please set the SCALA_RECORDS_HOME environment variable."))

  val scalacp = "/target/scala-2.11/classes/"
  lazy val lms = file(LMS_HOME + scalacp)
  lazy val deliteFramework = file(DELITE_HOME + "/framework" + scalacp)
  lazy val deliteRuntime = file(DELITE_HOME + "/runtime" + scalacp)
  lazy val deliteTest = file(DELITE_HOME + "/framework/delite-test" + scalacp)
  lazy val scalaRecords = file(SCALA_RECORDS_HOME + "/core" + scalacp)

  val deps = Seq(
    unmanagedClasspath in Compile <+= (baseDirectory) map { bd => Attributed.blank(lms) },
    unmanagedClasspath in Compile <+= (baseDirectory) map { bd => Attributed.blank(deliteFramework) },
    unmanagedClasspath in Compile <+= (baseDirectory) map { bd => Attributed.blank(deliteRuntime) },
    unmanagedClasspath in Compile <+= (baseDirectory) map { bd => Attributed.blank(deliteTest) },
    unmanagedClasspath in Compile <+= (baseDirectory) map { bd => Attributed.blank(scalaRecords) },
    unmanagedClasspath in Test <+= (baseDirectory) map { bd => Attributed.blank(lms) },
    unmanagedClasspath in Test <+= (baseDirectory) map { bd => Attributed.blank(deliteFramework) },
    unmanagedClasspath in Test <+= (baseDirectory) map { bd => Attributed.blank(deliteRuntime) },
    unmanagedClasspath in Test <+= (baseDirectory) map { bd => Attributed.blank(deliteTest) },
    unmanagedClasspath in Test <+= (baseDirectory) map { bd => Attributed.blank(scalaRecords) }
  )


  // HACK alert: with fork = true, sbt appears to ignore the -D properties passed on the command line,
  // which breaks test_all. Here we manually look for the currently relevant options. Needs a proper fix!
  val testOptions = Seq("-Dtests.verbose="+System.getProperty("tests.verbose", "false"),
                        "-Dtests.threads="+System.getProperty("tests.threads", "1"),
                        "-Dtests.targets="+System.getProperty("tests.targets", "scala"))

  // Test suites are run individually in different JVMs. Set TEST_JAVA_OPTS to configure JAVA_OPTS for each suite.
  val testJavaOptionsStr = sys.env.getOrElse("TEST_JAVA_OPTS", "")
  // TEST_JAVA_OPTS cannot be empty or SBT crashes when it gets a non-empty Seq containing an empty string.
  val testJavaOptions = if (testJavaOptionsStr == "") Seq() else testJavaOptionsStr.split(" ").toSeq

  def separateTests(tests: Seq[TestDefinition]) = {
    if (tests.isEmpty) Seq(new Group("", Seq(), SubProcess(Seq()))) //workaround for sbt crash on empty tests
    else tests map { test => new Group(test.name, Seq(test), SubProcess(testOptions ++ testJavaOptions)) }
  }

  // build targets
  lazy val SimpleVector = Project("SimpleVector", file("."), settings = virtBuildSettings ++ deps) dependsOn(SimpleVectorApps) // default
  lazy val SimpleVectorShared = Project("SimpleVector-shared", file("shared"), settings = virtBuildSettings ++ deps)
  lazy val SimpleVectorComp = Project("SimpleVector-comp", file("compiler"), settings = virtBuildSettings ++ deps) dependsOn(SimpleVectorShared)
  lazy val SimpleVectorLib = Project("SimpleVector-lib", file("library"), settings = virtBuildSettings ++ deps) dependsOn(SimpleVectorShared)
  lazy val SimpleVectorIdent = Project("SimpleVector-ident", file("ident"), settings = virtBuildSettings ++ deps) dependsOn(SimpleVectorShared)
  lazy val SimpleVectorShallow = Project("SimpleVector-shallow", file("shallow"), settings = virtBuildSettings ++ deps)
  lazy val SimpleVectorCdeep = Project("SimpleVector-cdeep", file("cdeep"), settings = virtBuildSettings ++ deps) dependsOn(SimpleVectorShallow)
  lazy val SimpleVectorApps = Project("SimpleVector-apps", file("apps"), settings = virtBuildSettings ++ deps) dependsOn(SimpleVectorComp, SimpleVectorLib, SimpleVectorIdent, SimpleVectorShallow, SimpleVectorCdeep)
  lazy val SimpleVectorTests = Project("SimpleVector-tests", file("tests"), settings = virtBuildSettingsBase ++ deps ++ Seq(
    scalaSource in Test <<= baseDirectory(_ / "src"),
    parallelExecution in Test := false,
    concurrentRestrictions in Test += Tags.limitAll(1), // don't run anything in parallel
    // Required to use native libraries within tests
    // See http://stackoverflow.com/questions/19425613/unsatisfiedlinkerror-with-native-library-under-sbt
    // and http://www.scala-sbt.org/release/docs/Forking.html
    testGrouping in Test <<= definedTests in Test map separateTests,
    fork := true
  )) dependsOn(SimpleVectorComp, SimpleVectorLib, SimpleVectorShallow, SimpleVectorCdeep)
}

