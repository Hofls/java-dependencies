### IntelliJ IDEA
* Wrong release version:
  * Error texts:
  ```
  java: error: release version 5 not supported
  SDK 21 does not support source version 1.5
  Source option 5 is no longer supported. Use 8 or later.
  Language leve is invalid or missing in pom.xml
  ```
  * Bad fix - add `<maven.compiler.source>` and `<maven.compiler.target>` to `pom.xml` \
    It's bad, because `maven.compiler.release` should be enough
  * Good fix:
    * Make sure problem is in maven version: \
      `File` -> `Settings` -> `Build` -> `Build Tools` -> `Maven` -> Replace `Maven wrapper` with `Bundled (Maven)`
    * Update your maven wrapper
