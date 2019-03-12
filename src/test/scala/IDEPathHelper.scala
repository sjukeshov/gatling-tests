import java.nio.file.Path

import io.gatling.commons.util.PathHelper._

object IDEPathHelper {

  val gatlingConfUrl: Path = getClass.getClassLoader.getResource("gatling.conf")
  val projectRootDir: Path = gatlingConfUrl.ancestor(3)

  val mavenSourcesDirectory: Path = projectRootDir / "src" / "test" / "scala"
  val mavenResourcesDirectory: Path = projectRootDir / "src" / "test" / "resources"
  val mavenTargetDirectory: Path = projectRootDir / "target"
  val mavenBinariesDirectory: Path = mavenTargetDirectory / "test-classes"

  val dataDirectory: Path = mavenResourcesDirectory / "data"
  val bodiesDirectory: Path = mavenResourcesDirectory / "bodies"

  val recorderOutputDirectory: Path = mavenSourcesDirectory
  val resultsDirectory: Path = mavenTargetDirectory / "gatling"

  val recorderConfigFile: Path = mavenResourcesDirectory / "recorder.conf"
}
