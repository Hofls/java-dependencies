#### Info
* Update dependencies to the latest versions: `mvn versions:use-latest-releases`
* If `install` throws error, to get more info: `mvn -X install`
* To look at all dependencies: `mvn dependency:tree`
* To show the real POM (parents + current + children) `mvn help:effective-pom`
* To find unused dependencies: `mvn dependency:analyze`
* To run spring boot `jar` in container - look at `devops` repository
* Local repository location: `/root/.m2/repository`
* To generate `pom.xml` from `build.gradle`
    * Add `id 'maven'` to `plugins` section
    * Run `gradle bootJar`, run `gradle install`
    * Look at `/build/poms/pom-default.xml`
* To deploy to artifactory:
    ```
        <distributionManagement>
            <snapshotRepository>
                <id>parsem.snapshot</id>
                <url>https://artifactory.parsem.net/artifactory/mvn-snapshot</url>
            </snapshotRepository>
        </distributionManagement>
    ```
  
#### Problems in pom.xml
* `<parent>`:
    * Adds dependencies with versions that may differ from child dependencies
    * To fix - set version in the main pom properties (e.g. `<kafka.version/>`)
* Order is important:
    * If different `<dependency>` add same library - version of the first one will be used
