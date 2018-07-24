/*
 * Copyright 2015 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import sbt.Keys._
import sbt._
import uk.gov.hmrc.SbtAutoBuildPlugin
import uk.gov.hmrc.versioning.SbtGitVersioning

object HmrcBuild extends Build {

  import uk.gov.hmrc.DefaultBuildSettings._
  import uk.gov.hmrc.PublishingSettings._
  import uk.gov.hmrc.{SbtBuildInfo, ShellPrompt, _}

  val appName = "play-json-logger"

  lazy val microservice = Project(appName, file("."))
    .enablePlugins(SbtAutoBuildPlugin, SbtGitVersioning)
    .settings(
      scalaVersion := "2.11.12",
      libraryDependencies ++= Seq(
        "com.typesafe.play" %% "play" % "2.5.18" % "provided",
        "commons-io" % "commons-io" % "2.6",
        "ch.qos.logback" % "logback-core" % "1.1.11",
        "ch.qos.logback" % "logback-classic" % "1.1.11"
      )
    )
    .disablePlugins(sbt.plugins.JUnitXmlReportPlugin)
}
