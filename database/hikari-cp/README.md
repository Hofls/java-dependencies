### HikariCP
* Connection leaks demo
* Useful & useless parameters
* Fully enabled logs
    * Pool parameters (jdbcUrl, maximumPoolSize, leakDetectionThreshold):
        * ctrl+F `com.zaxxer.hikari.HikariConfig`
    * Connections data (active, idle)
        * ctrl+f `com.zaxxer.hikari.pool.HikariPool`
    * Leaks:
        * ctrl+f `Apparent connection leak detected`, `Connection leak detection triggered`
