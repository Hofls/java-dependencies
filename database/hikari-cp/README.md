### HikariCP
* Useful parameters
    * `spring.datasource.hikari.leak-detection-threshold=35000`
        * Writes warning in logs if detects a leak 
* Fully enabled logs
    * Pool parameters (jdbcUrl, maximumPoolSize, leakDetectionThreshold):
        * ctrl+F `com.zaxxer.hikari.HikariConfig`
    * Connections data (active, idle)
        * ctrl+f `com.zaxxer.hikari.pool.HikariPool`
    * Leaks:
        * ctrl+f `Apparent connection leak detected`, `Connection leak detection triggered`
* Useless parameters (defaults are sane enough)
```
    spring.datasource.hikari.connection-test-query=SELECT 1
    spring.datasource.hikari.minimum-idle=10
    spring.datasource.hikari.maximum-pool-size=30
    spring.datasource.hikari.driver-class-name=org.postgresql.Driver
```
