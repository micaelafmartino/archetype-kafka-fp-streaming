import sbt.Keys._
import sbt._

object Dependencies {
  val scalaVersion        = "2.13.12"
  val catsEffectVersion   = "3.5.2"
  val fs2Version          = "3.9.2"
  val kafkaStreamsVersion = "3.6.0"
  val enumeratumVersion   = "1.7.3"

  lazy val forBaseProject = base ++ compilerPlugins ++ test

  lazy val compilerPlugins = Seq(
    "org.typelevel" % "kind-projector"     % "0.13.2" cross CrossVersion.full,
    "com.olegpy"   %% "better-monadic-for" % "0.3.1",
  ).map(compilerPlugin)

  /** General dependencies */
  lazy val base = Seq(
    // typelevel core
    "org.typelevel" %% "cats-effect" % catsEffectVersion,

    // streaming
    "co.fs2"           %% "fs2-core"            % fs2Version,
    "org.apache.kafka" %% "kafka-streams-scala" % kafkaStreamsVersion,

    // config
    "com.typesafe"           % "config"     % "1.4.3",
    "com.github.pureconfig" %% "pureconfig" % "0.17.4",

    // logging
    "org.slf4j"      % "slf4j-reload4j" % "2.0.9",
    "org.typelevel" %% "log4cats-slf4j" % "2.6.0",
  )

  lazy val test = Seq(
    "org.scalatest" %% "scalatest" % "3.2.17"
  ).map(_ % Test)

  lazy val settings = Seq(
    libraryDependencies ++= forBaseProject
  )
}
