import play.core.PlayVersion
import sbt.Keys._
import sbt._


val libName = "play-json-logger"

val compileDependencies = Seq(
  "com.typesafe.play" %% "play"           % PlayVersion.current,
  "commons-io"        %  "commons-io"     % "2.4",
  "ch.qos.logback"    % "logback-core"    % "1.1.7",
  "ch.qos.logback"    % "logback-classic" % "1.1.7"
)

lazy val playJsonLogger = Project(libName, file("."))
  .enablePlugins(SbtAutoBuildPlugin, SbtGitVersioning)
  .settings(
    majorVersion := 3,
    makePublicallyAvailableOnBintray := true,
    scalaVersion := "2.11.7",
    libraryDependencies ++= compileDependencies,
    crossScalaVersions := Seq("2.11.7"),
    resolvers := Seq(
      Resolver.bintrayRepo("hmrc", "releases"),
      "typesafe-releases" at "http://repo.typesafe.com/typesafe/releases/"
    )
  )
  .disablePlugins(sbt.plugins.JUnitXmlReportPlugin)