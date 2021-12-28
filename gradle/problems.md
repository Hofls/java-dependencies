##### Wrong Java version
* Problem: 
    ```
    The consumer was configured to find a runtime of a library compatible with Java 8, packaged as a jar, and its dependencies declared externally but:
    Incompatible because this component declares an API of a component compatible with Java 16 and the consumer needed a runtime of a component compatible with Java 8
    ```
* Solution:
    * IntelliJ → File → Settings → Build, Execution → Build Tools → Gradle → Gradle JVM → 16
    
##### Not found main class
* Problem: 
    ```
    Error: Could not find or load main class org.gradle.wrapper.GradleWrapperMain
    Caused by: java.lang.ClassNotFoundException: org.gradle.wrapper.GradleWrapperMain
    ```
* Solution:
    * Restore `gradle` folder (with gradle-wrapper.jar)

##### Console output with wrong encoding
* Problem:
    ```
    tasks.register("error-example") {
        doLast {
            println("Hello мир!")
        }
    }
    ```
* Solution (for cmd.exe):
    * Set console encoding to utf-8 - `chcp 65001`
    * Set gradle encoding to utf-8:
        * Environment variable - `GRADLE_OPTS`, value - `-Dfile.encoding=UTF-8`
* Solution (for IDEA run configs):
    * Help -> Find Action... -> Edit Custom VM Options...
    * Insert:
        * `-Dconsole.encoding=UTF-8`
        * `-Dfile.encoding=UTF-8`

##### Dependency hell
* Problem:
    * "Dependency A" uses "stax2-api:3.1.4". "Dependency B" uses "stax2-api:4.1.0"
    * Gradle picks the latest version (4.1.0), but "Dependency A" unable to use it (NoSuchMethodError)
* Solutions (pick one):
    * Exclude "Dependency A":
        ```
        dependencies {
            configurations {
                runtime.exclude group: "org.codehaus.woodstox", module: "woodstox-core-asl"
            }
        ```
    * Ask gradle to use an old version:
        ```
        implementation('org.codehaus.woodstox:stax2-api') {
            version {
                strictly '3.1.4'
            }
        }
        ```
