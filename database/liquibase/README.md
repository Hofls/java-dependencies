### Info
* Prerequisite: PostgreSQL running on localhost

### Generate changesets (Maven plugin)
* Notice: index generation is broken in version 3.4.1 
* Thanks to `liquibase-maven-plugin` (look at pom.xml)
* `clean install`
* `liquibase:diff`

### Generate changesets (IDEA - JPA Buddy)
* Notice: this plugin costs money
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

### If prod doesn't have an internet access:
* You will get an error:
```
Failed to read schema document 'http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-4.6.xsd', because 
1) could not find the document; 
2) the document could not be read; 
3) the root element of the document is not <xsd:schema>
```
* To fix it - download xsd file manually, put it on a classpath - `main/resources/xsd/dbchangelog-4.6.xsd`
* In each liquibase .xml file replace `http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.8.xsd` with `xsd/dbchangelog-3.8.xsd`
