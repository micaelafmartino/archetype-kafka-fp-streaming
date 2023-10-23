import scala.sys.process._

object Versioning {
  private val mainBranch = "main"

  def version: String = if (currentBranch == mainBranch) latestCommit else s"$currentBranch-SNAPSHOT"

  def currentBranch: String = "git rev-parse --abbrev-ref HEAD".!!.trim

  def latestCommit: String = "git rev-parse HEAD".!!.trim
}
