* If you get error
    ```
    Your build is currently configured to use incompatible Java 21.0.2 and Gradle 5.2.1. Cannot sync the project.
    We recommend upgrading to Gradle version 8.8.
    The minimum compatible Gradle version is 8.5.
    The maximum compatible Gradle JVM version is 11.
    ```
* Option 1 - use old SDK
  * `IntelliJ IDEA` -> `File` -> `Project structure` -> `Project` -> `SDK` -> `1.8`
* Option 2 - update dependencies
  * Open [project-templates](../project-templates)
  * Copy `gradle` folder
  * Copy `plugins` from `build.gradle`
  * Manually update versions of all other dependencies