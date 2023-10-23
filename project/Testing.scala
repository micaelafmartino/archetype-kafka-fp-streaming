import sbt.Keys._
import sbt._

object Testing {
  lazy val settings = inConfig(Test)(
    Seq(
      fork        := true,
      logBuffered := false,
      run / javaOptions += "-Xmx1G -Xmx2G",
    )
  )
}
