### Projects
* `Spring Framework` - provides programming/configuration model 
    * `Core` - Dependency injection (@Service, @Autowired), events, resources, i18n, validation, AOP, type conversion
    * `Testing`  - Mock objects, TestContext framework, WebTestClient
    * `Data Access` - Transactions, DAO support, JDBC, ORM
    * `Web` - Spring MVC, WebFlux 
    * `Integration` - scheduling, cache, cryptography, tasks
    * Dependency - `org.springframework.*`; Package - `org.springframework.*`
* `Spring Boot` - opinionated extension of Spring Framework, simplifies everything
    * Provides an embedded server, automatic configuration of libraries, starter dependencies, metrics
    * Dependency - `org.springframework.boot:*`; Package - `org.springframework.boot.*`
* `Spring Boot. Starter` - bundles of related dependencies
    * Alternative to manual dependency hunting and manual config
    * Dependency - `org.springframework.boot:spring-boot-starter*`;
* `Spring Data` - consistent model for data access
    * `Commons` - Repository & Mapping abstractions, Audit, Dynamic query derivation from method names
    * `JPA` - Repository, Specification, Query, Querydsl
    * `REST` - HATEOAS, HAL
    * `MongoDB`, `Redis`, `Cassandra`, and a lot of community modules
    * Dependency - `spring-data-*` or `spring-boot-starter-data-*`; Package - `org.springframework.data.*`
* `Spring Cloud`
    * Helps to build common patterns in distributed systems (microservices)
    * Provides integration with cloud services (e.g. AWS)
    * Dependency - `spring-cloud-*` or `spring-cloud-starter-*`; Package - `org.springframework.cloud.*`
* `Spring Security`
    * Provides authentication and authorization
    * Protects against attacks (e.g. session fixation, CSRF, clickjacking)
    * Dependency - `spring-security-*` or `spring-boot-starter-security`; Package - `org.springframework.security.*`
* `Spring for GraphQL`
    * Dependency - `pring-boot-starter-graphql`; Package - `org.springframework.graphql.*`

### Spring Framework. Core
* `IoC Container` manages beans - ApplicationContext, @Autowired, @Bean, @Service, @Repository, etc
    * Each bean is wrapped in a proxy. This allows execution of custom code, before real method call (e.g. Aspects, @Transactional)
    That's why stacktraces are so [big and weird](resources/stacktrace.png)
* `Bean scope`:
    * `Singleton` - default, 1 instance per IoC container
        * Example - `@Bean`, `@Repository`
    * `Request` - 1 instance per HTTP request
        * Example - `@Autowired HttpServletRequest request`
    * `Prototype` - rare, new instance for each injection
        * Example - `@Bean @Scope("prototype")`
* `Resource` - provides access to resources (files, http, classpath)
    * Location - org.springframework.core.io.Resource
