import com.typesafe.sbt.packager.Keys._
import sbt.Compile
import sbt.Keys._

import java.io.File

object SbtDocker {
  lazy val settings = Seq(
    dockerBaseImage    := "sapmachine:17.0.6",
    dockerUpdateLatest := true,
    Compile / packageBin / mappings ~= { (mappings: Seq[(File, String)]) =>
      mappings filter { case (file, toPath) => toPath != "local/personal.conf" }
    },
  )
}
