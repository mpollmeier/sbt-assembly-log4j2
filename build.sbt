lazy val root = (project in file(".")).
  settings(
    sbtPlugin := true,
    name := "sbt-assembly-log4j2",
    organization := "com.michaelpollmeier",
    description := "sbt assembly plugin merge strategy for log4j2 plugins",
    licenses := Seq("MIT License" -> url("https://github.com/idio/sbt-assembly-log4j2/blob/master/LICENSE")),
    scalacOptions := Seq("-deprecation", "-unchecked"),
    addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "2.1.1"),
    libraryDependencies += "org.apache.logging.log4j" % "log4j-core" % "2.20.0",
    crossSbtVersions := Seq("1.9.4"),
    crossScalaVersions := Seq("2.12.18"),   
    Compile / packageBin / publishArtifact := true,
    Test    / packageBin / publishArtifact := false,
    Compile / packageDoc / publishArtifact := false,
    Compile / packageSrc / publishArtifact := true,
  )
