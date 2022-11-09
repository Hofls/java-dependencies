### Info
* `SchemaSpy` - generates HTML documentation for database (tables, schemas, relations etc)

### Getting started
* Install dependencies:
    * [JDK 8](https://www.oracle.com/java/technologies/javase/javase8u211-later-archive-downloads.html)
    * [SchemaSpy](https://schemaspy.org/schemaspy/download.html)
    * [JDBC driver](https://jdbc.postgresql.org/download/postgresql-42.5.0.jar)
    * Create results folder
* Generate schema:
    ```
    D:/Programs/jdk1.8.0/bin/java.exe -jar D:/Programs/schemaspy-6.1.1-SNAPSHOT.jar -vizjs ^
    -t pgsql -host 103.143.23.45:5440 ^
    -db dev_db -s equipment ^
    -u postgres -p postgres ^
    -o D:/Programs/Result/ -dp D:/Programs/postgresql-42.5.0.jar
    ```
* Open `index.html` from results folder

### Useful CLI options
* Ignore tables:
    * `-I "(flyway_schema_history|databasechangelog|databasechangeloglock)"`
* Ignore views:
    * `-noviews`
