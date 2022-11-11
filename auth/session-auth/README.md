# Session based auth
Essence:
* User registered on a site, login and password are stored on the backend.
* User sends login and password to the `/auth/login` endpoint. 
    * If credentials are correct - backend send sends cookie with session id.
* Session ID is stored in the cookies on the frontend and sent with each request to the backend.
    * Each time backend checks that session id is present in DB (e.g. redis)

# How to run
* To run locally - `gradlew bootRun` 
    * Then open link in the browser [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
* To run on application server (Wildfly/Tomcat)
    * Build project - `gradlew bootWar`
    * Copy war file from `/build/libs/session-auth.war` to application server folder.  
    * Then launch server and open link [http://localhost:8080/session-auth/swagger-ui.html](http://localhost:8080/rest-backend/swagger-ui.html)