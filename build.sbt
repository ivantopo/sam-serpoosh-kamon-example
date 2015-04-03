import com.typesafe.sbt.SbtAspectj._

aspectjSettings

scalaVersion := "2.11.6"

val kamonVersion = "0.3.5"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.2",
  "com.typesafe.akka" %% "akka-slf4j" % "2.3.9",
  "ch.qos.logback" % "logback-classic" % "1.0.13",
  "io.kamon" %% "kamon-core" % kamonVersion,
  "io.kamon" %% "kamon-log-reporter" % kamonVersion,
  "io.kamon" %% "kamon-system-metrics" % kamonVersion,
  "org.scalatest" %% "scalatest" % "2.2.1" % "test")

fork in run := true

javaOptions in run <++= AspectjKeys.weaverOptions in Aspectj
