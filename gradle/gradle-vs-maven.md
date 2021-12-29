### Run spring-boot app
* Gradle: 
    * Add in build.gradle: `bootRun { systemProperties = System.properties }`
    * Execute: `gradlew bootRun --args='--spring.profiles.active=run-locally' -Dspring-boot.run.fork=false`
* Maven: 
    * Execute: `spring-boot:run -Dspring-boot.run.profiles=run-locally -Dspring-boot.run.fork=false`

### Set .jar name
* Gradle: 
    * Add in build.gradle: `bootJar { archiveFileName = "doctor-server.jar" }`
* Maven: 
    * Add in pom.xml`<build> <finalName>driver-server</finalName> </build>`
