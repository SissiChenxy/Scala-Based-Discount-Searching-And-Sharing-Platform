name := """play-scala-seed"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.6"

crossScalaVersions := Seq("2.12.6", "2.11.12")

dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-core" % "2.6.5"
dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.5"
dependencyOverrides += "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.6.5"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2"

libraryDependencies ++= Seq(
  "org.jsoup" % "jsoup" % "1.8.3",
  "org.scalaj" %% "scalaj-http" % "2.4.1",
  "org.scala-lang" % "scala-library" % "2.12.6",
  "com.typesafe.akka" %% "akka-actor" % "2.5.18",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.18",
  "org.scalatest" %% "scalatest" % "3.0.5",
  "org.apache.spark" %% "spark-sql" % "2.4.0",
  "net.sourceforge.htmlunit" % "htmlunit" % "2.33",
  "com.typesafe.play" %% "play-mailer" % "6.0.1",
  "com.typesafe.play" %% "play-mailer-guice" % "6.0.1"
)