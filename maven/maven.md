
* Update dependencies to the latest versions: `mvn versions:use-latest-releases`
* If `install` throws error, to get more info: `mvn -X install`
* To look at all dependencies: `mvn dependency:tree`
* To find unused dependencies: `mvn dependency:analyze`
* To run spring boot `jar` in container - look at `devops` repository
* To deploy to artifactory:
    ```
        <distributionManagement>
            <snapshotRepository>
                <id>parsem.snapshot</id>
                <url>https://artifactory.parsem.net/artifactory/mvn-snapshot</url>
            </snapshotRepository>
        </distributionManagement>
    ```