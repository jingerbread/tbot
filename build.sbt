name := "tbot"

version := "1.0"

scalaVersion := "2.11.1"

resolvers ++= List(
  "spray repo" at "http://repo.spray.io", // release builds
  "spray nightly" at "http://nightlies.spray.io" // snapshot builds
)

mainClass in (Compile,run) := Some("com.ifunsoftware.telegram.bot.HelloWorld")

libraryDependencies += "io.spray" %% "spray-client" % "1.3.4"