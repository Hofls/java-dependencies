#### TODO
* https://docs.gradle.org/current/userguide/declaring_dependencies_between_subprojects.html
* Moving from maven
    * https://docs.gradle.org/current/userguide/migrating_from_maven.html
    * https://gradle.org/gradle-vs-maven-performance/
    * https://gradle.org/maven-vs-gradle/
* Performance optimization
    * Add in  `#### Performance optimization` block
    * https://docs.gradle.org/current/userguide/performance.html
    * https://docs.gradle.org/current/userguide/build_cache_use_cases.html
    * gitlab - cache gradle `build` folder?
* https://plugins.gradle.org/
    * find most popular plugins
    * Core plugins - https://docs.gradle.org/current/userguide/plugin_reference.html
    * Find unused dependencies, lint: 
        * Plugin `id "nebula.lint" version "16.9.0"`
* https://gradle.org/features/
    
#### Commands
* Run app locally: `gradlew bootRun`
    * It's a Spring Boot alternative to `gradlew run`
* Build .jar: `gradlew bootJar`
    * It's a Spring Boot alternative to `gradlew build`
* Tasks:
    * Find tasks you can run: `gradlew tasks` (or better use IDE)
    * Task documentation: `gradlew help --task clean`
    * Run task: `gradlew clean`
* Generate everything gradle-related: `gradlew init` 
    * If `pom.xml` is present - generates `build.gradle` based on its content
* Troubleshooting:
    * Discover project structure: `gradlew projects`
        * If multiple projects showed up - it's a [multi-project build](multi-project-build/settings.gradle.kts)
    * Look at all dependencies: `gradlew dependencies`
        * If don't want duplicates: `gradlew --configuration runtimeClasspath`
    * Verbose output: `gradlew bootJar --debug --stacktrace`
    * Show which tasks executed: `gradlew depends-demo --console=plain`
    * Scan build: `gradlew bootJar --scan`
    * Profile build: `gradlew bootJar --profile`
    * Gradle version: `gradlew --version`
    * Daemon info: `gradlew --status`
    * File system info: `gradlew assemble -Dorg.gradle.vfs.verbose=true`
    
#### Performance optimization
* Incremental build (enabled by default):
    * Description:
        * AKA Up-to-date check
        * Re-uses unchanged files from previous build, only runs tasks whose inputs/outputs have changed
    * Stored in project folders: `.gradle`, `build`
    * Example:
        * First build: `gradlew build` -> `BUILD SUCCESSFUL. 14 actionable tasks: 14 executed`
        * Second build: `gradlew build` -> `BUILD SUCCESSFUL. 14 actionable tasks: 14 up-to-date`
* Build cache (disabled by default):
    * Description:
        * Re-uses unchanged files from previous build, only runs tasks whose inputs/outputs have changed
        * Deleted if haven't been used for 7 days
        * Saves output of `Execution` phase
    * Ways to enable (pick 1):
        * Add `org.gradle.caching=true` in `gradle.properties`
        * Run `gradlew build --build-cache`
    * Cache stored at `%userprofile%\.gradle\caches`
    * Cache activates if no `.gradle` or `build` folder present
        * E.g. when building in CI env (gitlab), or after `gradlew clean`
        * `BUILD SUCCESSFUL. 14 actionable tasks: 8 executed, 6 from cache`
* Parallel execution (disabled by default):
    * Ways to enable (pick 1):
        * Add `org.gradle.parallel=true` in `gradle.properties`
        * Run `gradlew build --parallel`
    * Clean comparison:
        * `gradlew build --parallel` -> `BUILD SUCCESSFUL in 3s`
        * `gradlew build` -> `BUILD SUCCESSFUL in 1s`
* Configuration cache (disabled by default)
    * Description:
        * Experimental feature
        * Deleted if haven't been used for 7 days
        * Saves output of `Configuration` phase
    * Ways to enable (pick 1):
        * Add `org.gradle.unsafe.configuration-cache=true` in `gradle.properties`
        * Run `gradlew build --configuration-cache`
    * Stored in project folder: `.gradle/configuration-cache`
* Daemon (enabled by default)
    * Always runs, helps to avoid slow startup times
    * To increase available RAM: add `org.gradle.jvmargs=-Xmx2048M` in `gradle.properties` 

#### Build environment
* Methods to configure gradle behaviour (ordered by descending priority):
    * Project properties - e.g. `gradlew publish -PmavenUsername=hofls`
    * Command-line flags - e.g. `gradlew build --build-cache`
    * System properties - e.g. `systemProp.http.proxyHost=somehost.org` stored in `gradle.properties`
        * or `gradle test -Dcassandra.ip=144.123.22.14`
    * Gradle properties - e.g. `org.gradle.caching=true` stored in `GRADLE_USER_HOME` env variable or `gradle.properties`
    * Environment variables - e.g. `GRADLE_OPTS` stored in environment

#### Etc
* Gradle is a build automation tool, runs on JVM
* Directed Acyclic Graphs (DAG) - describes order of tasks (e.g. compile -> assemble -> build))
* Gradle wrapper - downloads and installs gradle (one gradle per project)
* Build scan - record of what happened during build
* Task - atomic piece of work which a build performs (e.g. `gradlew clean`)
    * Most tasks come from plugins, some from `tasks.register()` in `build.gradle`
    * Tasks implemented as code (Kotlin/Groovy)
* Build scripts written with DSL:
    * Kotlin - new, statically typed (auto-completion, quick documentation, auto-refactoring)
    * Groovy - old, dynamically typed
    * [Convert Groovy to Kotlin](https://github.com/bernaferrari/GradleKotlinConverter)
* Fixed build phases [example](build-phases):
    * Initialization (set up environment)
    * Configuration (constructs and configures task graph)
    * Execution (runs the tasks)