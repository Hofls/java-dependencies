* To get more verbose output:
    * `gradle bootJar --debug --stacktrace`
* To look at all dependencies: `gradle dependencies`
* Find unused dependencies, lint: 
    * Plugin `id "nebula.lint" version "16.9.0"`
* To generate everything gradle-related, execute `gradle init` 
    * If `pom.xml` is present - generates `build.gradle` based on its content
