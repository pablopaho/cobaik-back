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
libraryDependencies += "org.postgresql" % "postgresql" % "9.3-1100-jdbc41"
libraryDependencies += "com.mohiva" %% "play-silhouette" % "4.0.0"
libraryDependencies += "com.mohiva" %% "play-silhouette-password-bcrypt" % "4.0.0"
libraryDependencies += "com.mohiva" %% "play-silhouette-persistence" % "4.0.0"
libraryDependencies += "com.mohiva" %% "play-silhouette-crypto-jca" % "4.0.0"
libraryDependencies += "com.mohiva" %% "play-silhouette-testkit" % "4.0.0" % "test"
libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.2"
libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.1.3"
libraryDependencies += "net.codingwell" %% "scala-guice" % "4.0.1"
libraryDependencies += "com.iheart" %% "ficus" % "1.2.6"
