
* To look at all dependencies: `mvn dependency:tree`
* To deploy to artifactory:
    ```
        <distributionManagement>
            <snapshotRepository>
                <id>parsem.snapshot</id>
                <url>https://artifactory.parsem.net/artifactory/mvn-snapshot</url>
            </snapshotRepository>
        </distributionManagement>
    ```