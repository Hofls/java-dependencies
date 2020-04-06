# Java SOAP backend 
Simple example (Hello world) of Java SOAP backend.

# How it works
`Apache CXF` generates java code based on `.wsdl` + `.xsd` files in module `soap-generation`.  
`application` module then uses generated code and publishes endpoints.  

Technology stack: 
* `Java` as a programming language
* `Spring Boot` for simple creation of Java Spring application
* `JAX-WS` to publish endpoints
* `Apache CXF` to generate Java code from schema description

# How to run
Build project by executing `mvn clean install`.  
* To run locally (debug mode) - launch `Application.java` directly from IDE.  
Then open link in browser [http://localhost:8080/soap/message](http://localhost:8080/soap/message)

* To run on application server (Wildfly/Tomcat)  
Copy war file from `/application/target/soap-backend.war` to application server folder.  
Then launch server and open link [http://localhost:8080/soap-backend/soap/message](http://localhost:8080/soap-backend/soap/message)

# Send SOAP request
To send SOAP request you can use SoapUI.  
Create new SOAP project with initial WSDL - `http://localhost:8080/soap/message?wsdl`  
It should automatically generate stub request for each operation.
