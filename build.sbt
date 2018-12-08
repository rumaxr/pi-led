name := "pi-led"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "4.3.5" % "test"
)

scalacOptions in Test ++= Seq("-Yrangepos")
