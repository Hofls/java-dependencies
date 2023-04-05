* To publish/deploy:
    * `gradlew publishToMavenLocal`
* To import:
    ```
    repositories {
        mavenLocal()
    }
    dependencies {
        implementation 'hofls.com.github:test-utils:0.1.0'
    }
    ```
