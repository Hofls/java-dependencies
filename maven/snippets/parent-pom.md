### Generic useful parent tags
* `<repositories>` - dependency resolution (artifactory, nexus)
* `<distributionManagement>` - deploy to repository
* `<pluginManagement>` - versions of plugins
* `distributionManagement` - versions of artifacts (dependencies)
* `<modules>` - links to child modules (to build all modules with 1 command)

### Same parent pom for all microservices

* Parent pom (set versions of dependencies):
```
    <groupId>com.soft.platform</groupId>
    <artifactId>platform-base</artifactId>
    <version>2024.07.08</version>
    <packaging>pom</packaging>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
                <version>1.18.32</version>
            </dependency>

            <dependency>
                <groupId>org.testcontainers</groupId>
                <artifactId>postgresql</artifactId>
                <version>1.19.8</version>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <build>
        <pluginManagement>
            <plugins>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-surefire-plugin</artifactId>
                    <version>2.22.2</version>
                </plugin>

                <plugin>
                    <groupId>org.liquibase</groupId>
                    <artifactId>liquibase-maven-plugin</artifactId>
                    <version>3.8.0</version>
                    <dependencies>
                        <dependency>
                            <groupId>org.postgresql</groupId>
                            <artifactId>postgresql</artifactId>
                            <version>42.2.24</version>
                        </dependency>
                    </dependencies>
                </plugin>
            </plugins>
        </pluginManagement>
    </build>
```

* Child pom (apply versions from parent pom):
```
    <parent>
        <groupId>com.soft.platform</groupId>
        <artifactId>platform-base</artifactId>
        <version>2024.07.08</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <dependencies>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <!-- No version specified here, it will use the version from parent dependencyManagement -->
        </dependency>
        <dependency>
            <groupId>org.testcontainers</groupId>
            <artifactId>postgresql</artifactId>
            <scope>test</scope>
            <!-- No version specified here, it will use the version from parent dependencyManagement -->
        </dependency>
    </dependencies>

    <build>
        <finalName>app</finalName>
        <plugins>
              <plugin>
                  <groupId>org.apache.maven.plugins</groupId>
                  <artifactId>maven-compiler-plugin</artifactId>
                  <!-- No version specified here, it will use the version from parent pluginManagement -->
              </plugin>
            <plugin>
                <groupId>org.liquibase</groupId>
                <artifactId>liquibase-maven-plugin</artifactId>
                <!-- No version specified here, it will use the version from parent pluginManagement -->
            </plugin>
        </plugins>
    </build>
```
