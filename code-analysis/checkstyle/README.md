* Run - `gradlew checkstyleMain`
* Not possible with checkstyle:
  * Ban interfaces with only 1 implementation
  * No packages with 25+ classes
* Checkstyle with maven:
```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-checkstyle-plugin</artifactId>
    <version>3.4.0</version>
    <configuration>
        <configLocation>src/main/resources/checkstyle.xml</configLocation>
    </configuration>
    <executions>
        <execution>
            <phase>validate</phase>
            <goals>
                <goal>check</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```
