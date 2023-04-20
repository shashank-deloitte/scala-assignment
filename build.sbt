ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.2"

lazy val root = (project in file("."))
  .settings(
    name := "scala-assignment"
  )

libraryDependencies += "com.typesafe" % "config" % "1.3.3"
libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.3.10"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % "test"



