#### Info
* Warning: better use gradle, but if you must use maven - here it goes
* Update dependencies to the latest versions: `mvn versions:use-latest-releases`
* If `install` throws error, to get more info: `mvn -X install`
* To look at all dependencies: `mvn dependency:tree`
* To show the real POM (parents + current + children) `mvn help:effective-pom`
* To find unused dependencies: `mvn dependency:analyze`
* To run spring boot `jar` in container - look at `devops` repository
* Skip tests: `mvn package -Dmaven.test.skip`
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
* If maven central not always available, use company repository first:
    * Add to `%HOMEPATH%/.m2/settings.xml`
    ```
    <mirrors>
        <mirror>
            <id>someit-repository</id>
            <url>https://nexus.someit.com/repository/central/</url>
            <mirrorOf>central</mirrorOf>
        </mirror>
    </mirrors>
    ```
  
#### Problems in pom.xml
* `<parent>`:
    * Adds dependencies with versions that may differ from child dependencies
    * To fix - set version in the main pom properties (e.g. `<kafka.version/>`)
* Order is important:
    * If different `<dependency>` add same library - version of the first one will be used

#### Other problems
* Maven uses wrong encoding on Windows to run tests (e.g. at `mvn clean install`)
    * Fix - explicitly set encoding - `mvn -DargLine=-Dfile.encoding=UTF-8 clean install`
        * Or add `-DargLine=-Dfile.encoding=UTF-8` to `.mvn/maven.config`
* If error appears `Failure to find dependency, was cached in the local repository, resolution will not be reattempted until the update interval of MyRepo has elapsed or updates are forced`
    * Means that problem has occurred during previous dependency download. Maven won't try to download it again for 24 hours (Insane default behaviour)
    * Fix - ask maven to try download broken dependency without 24h wait `mvn -U clean install`
