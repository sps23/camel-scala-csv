name := "camel-scala-csv"

version := "0.1"

scalaVersion := "2.12.10"

libraryDependencies ++= Seq(
  "com.github.melrief" %% "purecsv" % "0.1.1",
  "org.scalactic" %% "scalactic" % "3.0.8",
  "org.apache.camel" % "camel-core" % "2.24.2",
  "org.slf4j" % "slf4j-api" % "1.7.28",
  "org.scalacheck" %% "scalacheck" % "1.14.2" % Test,
  "org.slf4j" % "slf4j-simple" % "1.7.28" % Test,
  "org.apache.camel" % "camel-test" % "2.24.2" % Test
)
