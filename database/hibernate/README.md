# java-hibernate-example

#### Run locally
* Maven - execute `mvn clean spring-boot:run`
* Gradle - execute `gradlew bootRun`
* Connect with h2db console:
    * Open [link](http://localhost:8080/h2-console) in the browser
    * Fill the fields:
        * `User Name` is empty
        * `Driver`: `org.h2.Driver`
        * `JDBC URL` -  `jdbc:h2:file:~/example-db`
    
#### Open h2 console while running tests (on breakpoint)
* Insert `H2Configuration.java` in project, make sure package is scanned (e.g. look at `StudentRepositoryTestV2`)
* Insert thread breakpoint (By default - breakpoint stops entire VM)
* Run tests in debug mode, on breakpoint open [link](http://localhost:8086/)
    * Fill the fields:
        * `User Name` is empty
        * `Driver`: `org.h2.Driver`
        * `JDBC URL`: `jdbc:h2:mem:test-db`
