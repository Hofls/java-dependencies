* Create tables with `hibernate.ddl-auto` 
* Then execute custom SQL with:
    * `defer-datasource-initialization: true`
    * `initialization-mode: always`
    * `data: classpath:init.sql`
* Function syntax is a bit weird:
    * You have to replace `$$ with '` and `' with ''`
