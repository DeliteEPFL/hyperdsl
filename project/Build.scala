import sbt._
import Keys._
import java.io.File

import forge.preprocessor._

object HyperDSLBuild extends Build with ForgePreprocessor {

  if (System.getProperty("showSuppressedErrors") == null) System.setProperty("showSuppressedErrors", "false")

  val virtScala = Option(System.getenv("SCALA_VIRTUALIZED_VERSION")).getOrElse("2.11.2")
  val scalaTest = "org.scalatest" % "scalatest_2.11" % "2.2.2"
  val virtBuildSettingsBase = Defaults.defaultSettings ++ Seq(
    organization := "stanford-ppl",
    scalaOrganization := "org.scala-lang.virtualized",
    scalaVersion := virtScala,
    publishArtifact in (Compile, packageDoc) := false,
    
    //normal scala for the runtime and compiling generated code
    libraryDependencies += "org.scala-lang" % "scala-library" % virtScala, 
    libraryDependencies += "org.scala-lang" % "scala-compiler" % virtScala,
    libraryDependencies += scalaTest,

    libraryDependencies += "org.apache.commons" % "commons-math" % "2.2",
    libraryDependencies += "com.google.protobuf" % "protobuf-java" % "2.5.0",
    libraryDependencies += "org.apache.mesos" % "mesos" % "0.20.1",
    libraryDependencies += "org.apache.hadoop" % "hadoop-common" % "2.7.1",
    libraryDependencies += "org.apache.hadoop" % "hadoop-client" % "2.7.1",
    libraryDependencies += "org.apache.hadoop" % "hadoop-hdfs" % "2.7.1",
    libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.8.7",

    retrieveManaged := true,
    scalacOptions += "-Yno-generic-signatures",
    scalacOptions += "-Yvirtualize",

    //we need tests to run in isolation across all projects
    parallelExecution in Test := false,
    concurrentRestrictions in Global := (Tags.limitAll(1) :: Nil)
  )

  val deliteBuildSettings = virtBuildSettingsBase ++ Seq(
    scalaSource in Compile <<= baseDirectory(_ / "src"),
    scalaSource in Test <<= baseDirectory(_ / "tests")
  )

  val forgeBuildSettings = virtBuildSettingsBase ++ Seq(
    sources in Compile <<= (sourceManaged in Compile, sources in Compile, streams) map { (dir,files,s) => files.map(preprocess(dir,_,s)) }
  )

  // build targets
  //root directory makes this the default project
  lazy val hyperdsl = Project("hyperdsl", file("."),
    settings = deliteBuildSettings) aggregate(lms, framework, runtime, deliteTest, forge, scalaRecords, _yinyang)

  lazy val lms = Project("lms", file("virtualization-lms-core")) // additional settings are picked up in build.sbt of submodule

  lazy val framework = Project("framework", file("delite/framework"), settings = deliteBuildSettings) dependsOn(runtime, lms) // dependency on runtime because of Scopes
  lazy val deliteTest = Project("delite-test", file("delite/framework/delite-test"), settings = deliteBuildSettings) dependsOn(framework, runtime)

  lazy val dsls = Project("dsls", file("delite/dsls"), settings = deliteBuildSettings) aggregate(optiql)
  lazy val optiql = Project("optiql", file("delite/dsls/optiql"), settings = deliteBuildSettings) dependsOn(framework, deliteTest)

  lazy val apps = Project("apps", file("delite/apps"), settings = deliteBuildSettings) aggregate(optiqlApps)
  lazy val optiqlApps = Project("optiql-apps", file("delite/apps/optiql"), settings = deliteBuildSettings) dependsOn(optiql)

  lazy val runtime = Project("runtime", file("delite/runtime"), settings = deliteBuildSettings)

  lazy val forge = Project("forge", file("forge"), settings = forgeBuildSettings) dependsOn(lms) // additional settings are picked up in build.sbt of submodule

  // include all projects that should be built and tested in 'aggregate'
  lazy val tests = Project("tests", file("project/boot"), settings = deliteBuildSettings) aggregate(runtime, framework, deliteTest, dsls, apps)


  // scala-records build
  import com.typesafe.sbt.SbtScalariform
  import com.typesafe.sbt.SbtScalariform.ScalariformKeys

  import org.scalajs.sbtplugin.ScalaJSPlugin
  import ScalaJSPlugin._
  import ScalaJSPlugin.autoImport._
  val paradiseVersion = "2.0.0"
  val buildSettings = SbtScalariform.scalariformSettings ++ Seq(

    // Metadata
    version := "0.5-SNAPSHOT",
    organization := "ch.epfl.lamp",
    licenses := Seq("New BSD" -> url("https://raw2.github.com/scala-records/scala-records/master/LICENSE")),
    homepage := Some(url("https://github.com/scala-records/scala-records/")),
    organizationHomepage := Some(url("http://lamp.epfl.ch")),
    scmInfo := Some(ScmInfo(
      url("https://github.com/scala-records/scala-records.git"),
      "git://github.com/scala-records/scala-records.git")),
    pomExtra := (
      <developers>
        <developer>
          <id>gzm0</id>
          <name>Tobias Schlatter</name>
          <url>https://github.com/gzm0</url>
        </developer>
        <developer>
          <id>vjovanov</id>
          <name>Vojin Jovanovic</name>
          <url>https://github.com/vjovanov</url>
        </developer>
        <developer>
          <id>hubertp</id>
          <name>Hubert Plociniczak</name>
          <url>https://github.com/hubertp</url>
        </developer>
      </developers>),

    // Actual settings
    scalacOptions ++= Seq("-deprecation", "-feature"),
    autoAPIMappings := true,
    scalaVersion := "2.11.6",

    crossScalaVersions := Seq(
      "2.10.2", "2.10.3", "2.10.4",
      "2.11.0", "2.11.1", "2.11.2",
      "2.11.3", "2.11.4", "2.11.5",
      "2.11.6", "2.12.0-SNAPSHOT"),
    resolvers += Resolver.sonatypeRepo("snapshots"),
    libraryDependencies += {
      if (scalaVersion.value == "2.12.0-SNAPSHOT")
        "org.scalatest" % "scalatest_2.11" % "2.2.0" % "test"
      else
        "org.scalatest" %% "scalatest" % "2.2.0" % "test"
    },
    ScalariformKeys.preferences in Compile := formattingPreferences,
    ScalariformKeys.preferences in Test    := formattingPreferences
  )

  val publishSettings = Seq(
    publishMavenStyle := true,
    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases" at nexus + "service/local/staging/deploy/maven2")
    },
    publishArtifact in Test := false // just to be safe
  )

  val macroBuildSettings = buildSettings ++ Seq(
    libraryDependencies <+= (scalaVersion)("org.scala-lang" % "scala-reflect" % _),
    libraryDependencies ++= {
      if (scalaBinaryVersion.value == "2.10") Seq(
          compilerPlugin("org.scalamacros" % "paradise" % paradiseVersion cross CrossVersion.full),
          "org.scalamacros" %% "quasiquotes" % paradiseVersion cross CrossVersion.binary
      ) else Nil
    }
  )

  def formattingPreferences = {
    import scalariform.formatter.preferences._
    FormattingPreferences()
    .setPreference(RewriteArrowSymbols, false)
    .setPreference(AlignParameters, true)
    .setPreference(AlignSingleLineCaseStatements, true)
  }

  val sharedCoreSettings = (
    macroBuildSettings ++ publishSettings
  ) ++ Seq(
    name := "scala-records",
    autoCompilerPlugins := true
  )

  lazy val scalaRecords = project.in(file("scala-records"))
    .aggregate(synthPlugin, core, srtests)

  lazy val synthPlugin = project.in(file("scala-records/synthPlugin"))
    .settings(buildSettings: _*)
    .settings(
      exportJars := true,
      crossVersion := CrossVersion.full,
      libraryDependencies ++= Seq(
        "org.scala-lang" % "scala-compiler" % scalaVersion.value,
        "org.scala-lang" % "scala-reflect" % scalaVersion.value)
    )

  lazy val core = project.in(file("scala-records/core"))
    .settings(sharedCoreSettings: _*)
    .dependsOn(synthPlugin % "plugin")

  lazy val srtests = project.in(file("scala-records/tests"))
    .settings(macroBuildSettings: _*)
    .settings(
      name := "scala-records-tests",
      unmanagedSourceDirectories in Test ++= {
        if (scalaVersion.value >= "2.11")
          Seq(sourceDirectory.value / "test-2.11" / "scala")
        else
          Seq(sourceDirectory.value / "test-2.10" / "scala")
      }
    )
    .dependsOn(core)


  // scala-yinyang build
  import java.io.File
  import sbt._
  import Keys._
  import com.typesafe.sbt.SbtSite.SiteKeys._
  import Process._
  import com.typesafe.sbt.SbtScalariform
  import com.typesafe.sbt.SbtScalariform.ScalariformKeys
  import com.typesafe.sbt.SbtSite.site
  import com.typesafe.sbt.site.JekyllSupport.Jekyll
  import com.typesafe.sbt.SbtGhPages.ghpages
  import com.typesafe.sbt.SbtGit.git

  lazy val projectSettings = Seq[Setting[_]](
    version              := "0.2.0-SNAPSHOT",
    organization         := "ch.epfl.lamp",
    licenses             := Seq("New BSD" -> 
      url("https://raw.githubusercontent.com/scala-yinyang/scala-yinyang/master/LICENCE")),
    homepage             := Some(url("https://github.com/scala-yinyang/scala-yinyang")),
    organizationHomepage := Some(url("http://lamp.epfl.ch")),
    scmInfo              := Some(ScmInfo(
      url("https://github.com/scala-yinyang/scala-yinyang.git"),
      "scm:git:git://github.com/scala-yinyang/scala-yinyang.git"))
  )

  lazy val scalaSettings = Defaults.defaultSettings ++ Seq(
    scalaOrganization    := scalaOrg,
    scalaVersion         := "2.11.2",
    crossScalaVersions := Seq("2.11.0", "2.11.1", "2.11.2"),
    scalacOptions        := defaultScalacOptions
  )

  // libraries
  lazy val libraryDeps = Seq(
    libraryDependencies <<= scalaVersion(ver => Seq(
      scalaOrg % "scala-library" % ver,
      scalaOrg % "scala-reflect" % ver,
      scalaOrg % "scala-compiler" % ver,
      "org.scalatest" % "scalatest_2.11" % "2.1.5" % "test",
      "junit" % "junit" % "4.11" % "test" // we need JUnit explicitly
  )))

  // modules
  lazy val _yinyang      = Project(id = "root",             base = file("scala-yinyang")                   , settings = Project.defaultSettings ++ Seq(publishArtifact := false)) aggregate (yinyang, yy_core, yy_paradise, example_dsls)
  lazy val yy_core       = Project(id = "yinyang-core",     base = file("scala-yinyang/components/core")     , settings = defaults ++ Seq(name := "yinyang-core"))
  lazy val yy_paradise   = Project(id = "yinyang-paradise", base = file("scala-yinyang/components/paradise") , settings = defaults ++ paradise ++ Seq(name := "yinyang-paradise")) dependsOn(yy_core)
  lazy val yinyang       = Project(id = "scala-yinyang",    base = file("scala-yinyang/components/yin-yang") , settings = defaults ++ Seq(name := "scala-yinyang")) dependsOn(yy_core)  
  lazy val example_dsls  = Project(id = "example-dsls",     base = file("scala-yinyang/components/dsls")     , settings = defaults ++ Seq(publishArtifact := false)) dependsOn(yinyang)

  lazy val defaults = projectSettings ++ scalaSettings ++ formatSettings ++ libraryDeps ++ Seq(
    resolvers +=  "OSSH" at "https://oss.sonatype.org/content/groups/public",
    resolvers += Resolver.sonatypeRepo("snapshots"),
    resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
    testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework"),
    // paths - so we don't need to have src/main/scala ... just src/ test/ and resources/
    scalaSource in Compile <<= baseDirectory(_ / "src"),
    scalaSource in Test <<= baseDirectory(_ / "test"),
    resourceDirectory in Compile <<= baseDirectory(_ / "resources"),
    // sbteclipse needs some info on source directories:
    unmanagedSourceDirectories in Compile <<= (scalaSource in Compile)(Seq(_)),
    unmanagedSourceDirectories in Test <<= (scalaSource in Test)(Seq(_)),
    parallelExecution in Test := false,
    incOptions := incOptions.value.withNameHashing(true)
  )

  // add the macro paradise compiler plugin
  lazy val paradise = Seq(
    libraryDependencies += {
      val paradiseVersion =  
        if (scalaVersion.value == "2.11.2") "2.0.1"
        else"2.0.0"
      compilerPlugin("org.scalamacros" % "paradise" %  paradiseVersion cross CrossVersion.full)
    },
    scalacOptions := defaultScalacOptions
  )

  lazy val website = Seq(site.settings,
    ghpages.settings,
    site.includeScaladoc(),
    site.jekyllSupport(),
    git.remoteRepo := "git@github.com:scala-yinyang/scala-yinyang.git",
    includeFilter in Jekyll := ("*.html" | "*.png" | "*.js" | "*.css" | "CNAME")
  )

  lazy val publishing = Seq(
    // for integration testing against scala snapshots
    resolvers += Resolver.sonatypeRepo("snapshots"),
    // so we don't have to wait for maven central synch
    resolvers += Resolver.sonatypeRepo("releases"),
    // If we want on maven central, we need to be in maven style.
    publishMavenStyle := true,
    publishArtifact in Test := false,
    // The Nexus repo we're publishing to.
    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases"  at nexus + "service/local/staging/deploy/maven2")
    },
    // Maven central cannot allow other repos.  We're ok here because the artifacts we
    // we use externally are *optional* dependencies.
    pomIncludeRepository := { _ => false },
    pomExtra := (
      <developers>
        <developer>
          <id>vjovanov</id>
          <name>Vojin Jovanovic</name>
          <url>http://www.vjovanov.com/</url>
        </developer>
        <developer>
          <id>amirsh</id>
          <name>Amir Shaikhha</name>
          <url>http://people.epfl.ch/amir.shaikhha</url>          
        </developer>
        <developer>
          <id>sstucki</id>
          <name>Sandro Stucki</name>
          <url>http://people.epfl.ch/sandro.stucki</url>          
        </developer>        
      </developers>
    )
  )

  lazy val formatSettings = SbtScalariform.scalariformSettings ++ Seq(
    ScalariformKeys.preferences in Compile := formattingPreferencesYY,
    ScalariformKeys.preferences in Test    := formattingPreferencesYY
  )

  def formattingPreferencesYY = {
    import scalariform.formatter.preferences._
    FormattingPreferences()
    .setPreference(RewriteArrowSymbols, false)
    .setPreference(AlignParameters, true)
    .setPreference(AlignSingleLineCaseStatements, true)
  }
  lazy val defaultScalacOptions = Seq("-deprecation", "-feature", "-language:higherKinds", "-language:implicitConversions")
  lazy val scalaOrg = "org.scala-lang"

}
