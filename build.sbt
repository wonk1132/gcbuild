lazy val root = (project in file("."))
  .settings(
    organization := "com.example",
    name := "quickstart",
    version := "latest",
    scalaVersion := "2.13.4",
    libraryDependencies ++= Seq(
    )
  )

dockerImageCreationTask := (publishLocal in Docker).value
dockerBaseImage         := "adoptopenjdk/openjdk8:alpine-jre"
dockerAlias             := DockerAlias(
  Some("gcr.io"),
  Some("gridcure-dev"),
  "gcbuild",
  Some("latest")
)

enablePlugins(JavaAppPackaging)
enablePlugins(AshScriptPlugin)
enablePlugins(DockerComposePlugin)
