name := "tbot"

version := "1.0"

scalaVersion := "2.11.8"

resolvers ++= List(
  "spray repo" at "http://repo.spray.io", // release builds
  "spray nightly" at "http://nightlies.spray.io" // snapshot builds
)

mainClass in (Compile,run) := Some("com.ifunsoftware.telegram.bot.HelloWorld")

libraryDependencies += "io.spray" %% "spray-client" % "1.3.4"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.4.17"

libraryDependencies += "org.apache.logging.log4j" % "log4j-api" % "2.8.1"

libraryDependencies += "org.apache.logging.log4j" % "log4j-core" % "2.8.1"