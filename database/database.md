For more info, look at `devops/database` repository

#### Configuration
* HikariCP
    * [Configuration docs](https://github.com/brettwooldridge/HikariCP#gear-configuration-knobs-baby)
    * Examples:
        * spring.datasource.hikari.maximum-pool-size=30
* Postgres
    * [Configuration docs](https://jdbc.postgresql.org/documentation/head/connect.html)
    * Examples:
        * jdbc:postgresql://122.143.33.2:5432/dbname?preparedStatementCacheQueries=0
        * spring.datasource.hikari.data-source-properties.preparedStatementCacheQueries=0
* Hibernate
    * [Configuration docs](https://docs.jboss.org/hibernate/orm/3.3/reference/en/html/session-configuration.html)
    * Examples:
        * spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQL95Dialect
#### Etc
* To write readable inserts - use csv aligner
    * e.g. http://www.listdiff.com/align-csv-text-columns-online-tool
