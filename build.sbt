name := "pi-led"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "com.pi4j" % "pi4j-core" % "1.1",
  "org.specs2" %% "specs2-core" % "4.3.5" % "test"
)

scalacOptions in Test ++= Seq("-Yrangepos")
