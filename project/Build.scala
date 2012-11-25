import sbt._
import Keys._
import com.twitter.sbt._

object SumitoSchemeBuild extends Build {

  lazy val sumitoScheme = Project(
    id = "sumito-scheme", 
    base = file("."), 
    settings = StandardProject.newSettings
  ).settings(
    Seq(
      version := "0.0.1", 
      scalaVersion := "2.10.0-RC2", 
      libraryDependencies ++= Seq(
        "org.specs2" %% "specs2" % "latest.integration" % "test"
      )
    ): _*
  )

}

