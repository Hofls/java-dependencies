# Simple Java project template 
Contains plugins that are useful in any java project

# Gradle
* To run - `gradlew bootRun`
* To build - `gradlew clean build`
* To list all possible tasks - `gradlew tasks`
* To generate everything gradle-related, execute `gradle init` 
    (if `pom.xml` is present - generates `build.gradle` based on its content)
#### Plugins: 
* `junit` - runs unit tests
    * to run manually - `gradlew test`
    * full report - `build/reports/tests/test/index.html`
* `spotless` - formats code
    * to run manually - `gradlew spotlessApply`
* `spotbugs` - spots bugs (better use SonarQube)
    * to run manually - `gradlew check`
    * full report - `build/reports/spotbugs/main.html`
* `pitest` - runs mutation tests
    * to run manually - `gradlew pitest`
    * full report is located in folder `build/reports/pitest/index.html`
* `dependencycheck` - looks for vulnerabilities in dependencies (via CVE)
    * to run manually - `gradlew dependencyCheckAnalyze`

# Maven
* To build `mvn -U clean install`
    * runs all plugins
* To run locally - `mvn spring-boot:run`
    * skips all plugins
#### Plugins: 
* `junit` - runs unit tests
    * to run manually - `mvn surefire:test`
* `fmt-maven` - formats code
    * to run manually - `mvn fmt:format`
* `spotbugs` - spots bugs (better use SonarQube)
    * to run manually - `mvn spotbugs:check`
    * full report - `mvn spotbugs:gui`
* `pitest` - runs mutation tests
    * to run manually - `mvn pitest:mutationCoverage`
    * full report is located in folder `target/pit-reports`

# Against code formatting plugins
* No good plugin was found (2022), auto formatting makes code cumbersome and reduces readability
* A. Without auto-format:
```
boolean sameSareEvent = entryGroups.stream().anyMatch(info -> Objects.equals(info.getSareEventId(), sareEvent));
```
* A. With auto-format:
```
boolean sameSareEvent =
      entryGroup.stream()
              .anyMatch(
                      info ->
                              Objects.equals(
                                      info.getSareEventId(), sareEvent));
```
* B. Without auto-format:
    ```
    TagUtils.refreshTag(currentTags, SCHEMA_UNREGISTERED_USER, CODE_UNREGISTERED_USER, user.getName());
    TagUtils.refreshTag(currentTags, SCHEMA_UNREGISTERED_USER, CODE_UNREGISTERED_USER, user.getName());
    TagUtils.refreshTag(currentTags, SCHEMA_UNREGISTERED_USER, CODE_UNREGISTERED_USER, user.getName());
    TagUtils.refreshTag(currentTags, SCHEMA_UNREGISTERED_USER, CODE_UNREGISTERED_USER, user.getName());
    ```
* B. With auto-format:
    ```
    TagUtils.refreshTag(
          currentTags,
          SCHEMA_UNREGISTERED_USER,
          CODE_UNREGISTERED_USER,
          user.getName());
    TagUtils.refreshTag(
          currentTags,
          SCHEMA_UNREGISTERED_USER,
          CODE_UNREGISTERED_USER,
          user.getName());
    TagUtils.refreshTag(
          currentTags,
          SCHEMA_UNREGISTERED_USER,
          CODE_UNREGISTERED_USER,
          user.getName());
    TagUtils.refreshTag(
          currentTags,
          SCHEMA_UNREGISTERED_USER,
          CODE_UNREGISTERED_USER,
          user.getName());
    ```
