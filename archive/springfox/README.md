# Springfox (OUTDATED)
* Better use springdoc

#### Gradle
* Run locally:
    * Pick one:
        * logs in console - `gradlew bootRun --args='--spring.profiles.active=run-locally'`
        * logs in file -  `gradlew bootRun`
    * Then open link in the browser [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)

#### .jar (possibly in Docker container)
* Execute commands:
    * `mvn clean bootJar`
    * `cd build/libs`
    * `java -jar rest-backend.jar`
* Open link [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)

#### Weird stuff:
* LocalTime:
    * Must add to Docket:
    ```
    .directModelSubstitute(LocalTime.class, String.class)
    ```
    * So LocalTime will work:
    ```
    @Schema(example = "[\"12:30\", \"21:00\"]")
    private List<LocalTime> times;
    ```
* 