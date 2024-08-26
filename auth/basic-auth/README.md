# Basic auth
* `Basic auth` - Each request should contain header with login and password (encoded with base64)
* To run locally - `gradlew bootRun` 
    * Then open link in the browser [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
* To run on application server (Wildfly/Tomcat)
    * Build project - `gradlew bootWar`
    * Copy war file from `/build/libs/basic-auth.war` to application server folder.  
    * Then launch server and open link [http://localhost:8080/basic-auth/swagger-ui.html](http://localhost:8080/rest-backend/swagger-ui.html)