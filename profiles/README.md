##### Gradle
* `gradle bootRun --args='--spring.profiles.active=dev-profile'`
* Build & run:
    * `gradle bootJar`
    * `cd build/libs`
    * `java -Dspring.profiles.active=dev-profile -jar profiles.jar`

##### Maven
* Run locally:
    * `mvn spring-boot:run -Dspring-boot.run.profiles=dev-profile`
* Build & run:
    * `mvn -U install`
    * `cd target`
    * `java -Dspring.profiles.active=dev-profile -jar profiles.jar`
