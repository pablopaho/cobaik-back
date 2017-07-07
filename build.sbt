name := """cobaik-backend"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.11"

libraryDependencies += cache
libraryDependencies += ws
libraryDependencies += evolutions
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0" % Test
libraryDependencies += "com.typesafe.slick" %% "slick" % "3.2.0"
libraryDependencies += "com.typesafe.play" %% "play-slick" % "2.1.0"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "2.1.0"
libraryDependencies += "com.h2database" % "h2" % "1.4.191"
libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1206-jdbc42"
libraryDependencies += evolutions
libraryDependencies += filters
