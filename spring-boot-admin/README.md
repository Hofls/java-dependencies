# Spring Boot Admin template 
Simple template of Spring Boot Admin application.

# How it works
`application` gathers metrics and exposes them at numerous endpoints, notifies `admin` about new client.  
`admin` creates web interface, continuously receives metrics from exposed endpoints.

Technology stack: 
* `Java` as a programming language
* `Spring Boot` for simple creation of Java Spring application
* `Spring Boot Actuator` to gather and expose metrics
* `Spring Boot Admin` to receive metrics and create web-interface for admin

# How to run
* To run locally (debug mode):
    * from `admin` folder - `mvn spring-boot:run`
    * from `application` folder - `mvn spring-boot:run -P dev`  
    * Then open links in the browser:
        * [http://localhost:8099/actuator](http://localhost:8099/actuator)
        * [http://localhost:8199/#/applications](http://localhost:8199/#/applications)

* To run on application server (Wildfly/Tomcat):
    * Build project by executing `mvn clean install -P test` (from `root` folder)  
    * Copy war files from `admin/target/admin.war` and `application/target/application.war` to application server folder.   
    * Then launch server and open links:
        * [http://localhost:8080/application/actuator](http://localhost:8080/application/actuator)
        * [http://localhost:8080/admin/#/applications](http://localhost:8080/admin/#/applications)
