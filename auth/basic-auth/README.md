# basic auth
In basic HTTP authentication, a request contains a header field in the form of Authorization: Basic <credentials>, where credentials is the base64 encoding of id and password joined by a single colon :
* Pros: 
    * Simplest auth method
* Cons:
    * Logout is very hacky
    * Have to send login and password on each request
    * Way less popular than other methods of authentication

# How to run
* To run locally - `gradlew bootRun` 
    * Then open link in the browser [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
* To run on application server (Wildfly/Tomcat)
    * Build project - `gradlew bootWar`
    * Copy war file from `/build/libs/basic-auth.war` to application server folder.  
    * Then launch server and open link [http://localhost:8080/basic-auth/swagger-ui.html](http://localhost:8080/rest-backend/swagger-ui.html)