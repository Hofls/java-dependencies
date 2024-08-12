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
* To externalize config (checkstyle.xml) in maven, [add it as a plugin dependency](https://stackoverflow.com/questions/19682455/how-to-externalise-the-checkstyle-config-for-maven-checkstyle-plugin)
  * Notice that `<configLocation>` is different, it starts with `resources`, so you don't need `/src/main/resources`
