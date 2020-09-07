import Dependencies._

ThisBuild / scalaVersion     := "2.11.12"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "medium-spark-datasets",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += sparkCore % Provided,
    libraryDependencies += sparkSql % Provided,
    libraryDependencies += scalaReflect % Provided

  )

scalacOptions ++= Seq( "-optimize" )