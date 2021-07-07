### Info
* Prerequisite: PostgreSQL running on localhost

### Generate changesets (Maven plugin)
* Thanks to `liquibase-maven-plugin` (look at pom.xml)
* `clean install`
* `liquibase:diff`

### Generate changesets (IDEA - JPA Buddy)
* Disclaimer: this plugin costs money
* Run IDEA as Admin
* Install JPA Buddy plugin
* JPA Structure -> Diff Liquibase Changelog -> Add new DB connection
* Will generate a changeset:
    ```
    <changeSet id="1624516905538-1" author="Home (generated)">
        <createTable tableName="student">
            <column autoIncrement="true" name="id" type="BIGINT">
                <constraints nullable="false" primaryKey="true" primaryKeyName="PK_STUDENT"/>
            </column>
            <column name="first_name" type="VARCHAR(255)"/>
        </createTable>
    </changeSet>
    ```

### Generate changesets (Maven Plugin)
* [TODO](https://www.baeldung.com/liquibase-refactor-schema-of-java-app)
