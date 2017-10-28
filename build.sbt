name := """cobaik-backend"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.11"

libraryDependencies += cache
libraryDependencies += ws
libraryDependencies += evolutions
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0" % Test
libraryDependencies += "org.mockito" % "mockito-core" % "1.9.0" % "test"
libraryDependencies += "com.typesafe.slick" %% "slick" % "3.2.0"
libraryDependencies += "com.typesafe.slick" %% "slick-codegen" % "3.2.0"
libraryDependencies += "com.typesafe.slick" %% "slick-hikaricp" % "3.2.0"
libraryDependencies += "com.typesafe.play" %% "play-slick" % "2.1.0"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "2.1.0"
libraryDependencies += "com.github.tototoshi" %% "slick-joda-mapper" % "2.3.0"
libraryDependencies += "com.h2database" % "h2" % "1.4.191"
libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1206-jdbc42"
libraryDependencies += "com.typesafe.play" %% "play-mailer" % "6.0.1"
libraryDependencies += "com.typesafe.play" %% "play-mailer-guice" % "6.0.1"
libraryDependencies += "net.codingwell" %% "scala-guice" % "4.1.0"
libraryDependencies += "com.github.tminglei" %% "slick-pg" % "0.15.0"
libraryDependencies += "com.github.tminglei" %% "slick-pg_joda-time" % "0.14.3"
libraryDependencies += "joda-time" % "joda-time" % "2.7"
libraryDependencies += "org.joda" % "joda-convert" % "1.7"
libraryDependencies += evolutions
libraryDependencies += filters
