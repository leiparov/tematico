name := "tematico"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)     

play.Project.playJavaSettings

play.Keys.lessEntryPoints <<= baseDirectory { base =>
    (base / "app" / "assets" / "stylesheets" ** "main.less") +++
    (base / "app" / "assets" / "stylesheets" ** "login.less")
}

templatesImport += "_root_.utils._"