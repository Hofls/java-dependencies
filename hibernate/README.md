# java-hibernate-example

#### Run locally
* Maven - execute `mvn clean spring-boot:run`
* Gradle - execute `gradlew bootRun`
* Connect with h2db console:
    * Open [link](http://localhost:8080/h2-console) in the browser
    * Fill the fields:
    * `User Name` is empty
    * `JDBC URL` -  `jdbc:h2:file:~/example-db`

#### Application server
* Maven = execute `mvn clean install`
     * `.war` file location - `target/java-hibernate-example.war`
* Gradle = execute `gradlew bootWar`
    * `.war` file location - `build/libs/java-hibernate-example.war`
* Copy `.war` file to the app server folder and run it
* Connect with h2db console:
    * Open [link](http://localhost:8080/hibernate-example/h2-console) in the browser
    * Fill the fields:
    * `User Name` is empty
    * `JDBC URL` -  `jdbc:h2:file:~/example-db`
* PS Tested on Wildfly & Tomcat

#### Usage with non-embedded DB (Postgres)
* Install and run postgres
* Set user, password and url in file `storage-postgres.properties`
* Activate postgres configuration:
    * In file `JpaConfig.java` replace `storage-h2db.properties` with `storage-postgres.properties`
* Run project

#### Etc
* [Spring Initializr](https://start.spring.io/) was used to create app template.