import EndpointsSettings._

val `stub-server` =
  project
    .in(file("."))
    .settings(
      publishSettings,
      `scala 2.13`,
      name := "stub-server",
//      versionPolicyIntention := Compatibility.None,
      libraryDependencies ++= Seq(
        "org.apache.pekko" %% "pekko-http" % pekkoHttpVersion,
        "org.apache.pekko" %% "pekko-stream" % pekkoActorVersion,
        "com.softwaremill.sttp.client3" %% "core" % sttpVersion,
        "com.softwaremill.sttp.client3" %% "httpclient-backend" % sttpVersion,
        "com.typesafe.play" %% "play" % playVersion,
        "io.github.jmcardon" %% "tsec-hash-jca" % "0.4.0",
        "org.scalaj" %% "scalaj-http" % "2.4.2",
        "com.github.pathikrit" %% "better-files" % "3.9.2"
      )
    )
