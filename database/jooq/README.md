### Jooq. Getting started
* Prerequisite - locally running PostgreSQL
* Manually create tables in PostgreSQL:
    ```
    CREATE TABLE AUTHOR (
      ID SERIAL PRIMARY KEY,
      FIRST_NAME VARCHAR(50),
      LAST_NAME VARCHAR(50)
    );
    
    CREATE TABLE BOOK (
      ID SERIAL PRIMARY KEY,
      TITLE VARCHAR(100),
      AUTHOR_ID INT,
      CONSTRAINT FK_AUTHOR FOREIGN KEY (AUTHOR_ID) REFERENCES AUTHOR(ID)
    );
    ```
* Generate classes based on DB tables:
  * Maven - `mvnw clean generate-sources`
  * Gradle - `gradlew clean generateJooq`
* Mark `target/generated-sources` folder in IDEA
* Run app:
  * Maven - `mvn compile exec:java -Dexec.mainClass=hofls.com.github.App`
  * Gradle - `gradlew run`
