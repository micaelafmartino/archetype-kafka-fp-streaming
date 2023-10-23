import BaseProject.projectName

lazy val kafkaFPStreaming = Project(id = projectName, base = file("."))
  .settings(
    BaseProject.settings,
    Dependencies.settings,
    SbtDocker.settings,
    Testing.settings,
  )
  .enablePlugins(JavaServerAppPackaging, DockerPlugin)
