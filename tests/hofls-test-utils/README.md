* To publish/deploy:
    * `gradlew publishToMavenLocal`
* To import:
    ```
    repositories {
        mavenLocal()
    }
    dependencies {
        implementation 'com.github.hofls:test-utils:0.1.0'
    }
    ```
