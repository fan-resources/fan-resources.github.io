import Common.*

lazy val fanResources = Project(id = "fan-resources", base = file("fan-resources"))

lazy val `net-site` = project
  .in(file("net-site"))
  .settings(buildSettings)
  .settings(
    name := "net-site",
    version := "0.1.0-SNAPSHOT",

    // 2.13 compatibility
    libraryDependencies ++= Seq(
      "com.typesafe" % "config" % "1.4.3"
    ),
  )
  .dependsOn(fanResources)

lazy val root = (project in file("."))
  .aggregate(fanResources, `net-site`)
  .settings(buildSettings)
  .settings(
    Compile / mainClass := Some("org.skyluc.fan_resources_net.Main"),
    Compile / watchSources ++= Seq(
      baseDirectory.value / "fan-resources" / "static",
      baseDirectory.value / "fan-resources" / "static_pieces",
      baseDirectory.value / "net-site" / "static",
      baseDirectory.value / "net-site" / "static_pieces",
    ),
  )
  .dependsOn(`net-site`)
