##### Wrong Java version
* Problem: 
    ```
    The consumer was configured to find a runtime of a library compatible with Java 8, packaged as a jar, and its dependencies declared externally but:
    Incompatible because this component declares an API of a component compatible with Java 16 and the consumer needed a runtime of a component compatible with Java 8
    ```
* Solution:
    * IntelliJ → File → Settings → Build, Execution → Build Tools → Gradle → Gradle JVM → 16