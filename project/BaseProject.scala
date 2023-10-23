import sbt.Keys._
import sbt._

object BaseProject {
  val projectName = "archetype-kafka-fp-streaming"

  lazy val settings = Seq(
    name         := projectName,
    organization := "mm",
    version      := Versioning.version,
    crossVersion := CrossVersion.disabled,
    scalaVersion := Dependencies.scalaVersion,
    scalacOptions ++= Seq("-deprecation", "-feature"),
  )
}
