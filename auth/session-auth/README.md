# How to run
* To run locally - `gradlew bootRun` 
    * Then open link in the browser [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
* To run on application server (Wildfly/Tomcat)
    * Build project - `gradlew bootWar`
    * Copy war file from `/build/libs/session-auth.war` to application server folder.  
    * Then launch server and open link [http://localhost:8080/session-auth/swagger-ui.html](http://localhost:8080/rest-backend/swagger-ui.html)