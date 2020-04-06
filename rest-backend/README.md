# Java REST backend 
Simple example (Hello world) of Java REST backend with Swagger.

# How it works
`Spring Boot` publishes endpoints from classes annotated with `@RestController`.  
Then `Swagger` generates UI to work with the endpoints.

Technology stack: 
* `Java` as a programming language
* `Spring Boot` for simple creation of Java Spring application
* `Swagger` to create user interface

# How to run
#### .jar (possibly in Docker container)
* Execute commands:
    * `mvn clean bootJar`
    * `cd build/libs`
    * `java -jar rest-backend.jar`
* Open link [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

#### Maven
Build project by executing `mvn clean install`.  
* To run locally (debug mode) - `mvn clean spring-boot:run`
Then open link in the browser [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

* To run on application server (Wildfly/Tomcat)  
Copy war file from `/target/rest-backend.war` to application server folder.  
Then launch server and open link [http://localhost:8080/rest-backend/swagger-ui.html](http://localhost:8080/rest-backend/swagger-ui.html)

#### Gradle
* Run locally:
    * Pick one^  
        * logs in console - `gradlew bootRun --args='--spring.profiles.active=run-locally'`
        * logs in file -  `gradlew bootRun`
    * Then open link in the browser [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
* To run on application server (Wildfly/Tomcat)
    * Build project - `gradlew bootWar`
    * Copy war file from `/build/libs/rest-backend.war` to application server folder.  
    * Then launch server and open link [http://localhost:8080/rest-backend/swagger-ui.html](http://localhost:8080/rest-backend/swagger-ui.html)

# How to generate REST client
* Installation:
    * [Download file](http://central.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.5/swagger-codegen-cli-2.4.5.jar)
    * Move file to folder `%USERPROFILE%\swagger-codegen-cli\`
    
* Code generation:
```
java -jar %USERPROFILE%\swagger-codegen-cli\swagger-codegen-cli-2.4.5.jar generate ^
  -i http://localhost:8080/v2/api-docs?group=default ^
  -l java ^
  -o %USERPROFILE%/Desktop/swagger-rest-client
```
Generated code will appear on the desktop, inside `swagger-rest-client` folder

