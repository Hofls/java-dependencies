#### Run build+tests in Docker (dind alternative)
* Preparations:
    * Prerequisites - installed Docker
    * Copy this directory to server, open it
    * There is no docker in `Dockerfile-test`, that's ok, --volume is enough for test-containers
* Build:
    * `cp docker/Dockerfile-build Dockerfile`
    * `DOCKER_BUILDKIT=1 docker build --tag build-example .`
* Test:
    * `cp docker/Dockerfile-test Dockerfile`
    * `docker build --tag tests-example .`
    * `docker run --volume /var/run/docker.sock:/var/run/docker.sock tests-example`

#### Run locally:
* Install docker
* Run - `./gradlew clean test -info`

#### Containers reuse
* Use case - you don't want to waste time by launching new containers each time.
* Set reuse property in code - `postgresContainer.withReuse(true);`
* Activate property
    * In file - `C:/Users/Hofls/.testcontainers.properties`
    * Add line - `testcontainers.reuse.enable=true`
* If not working - look at logs[https://www.testcontainers.org/supported_docker_environment/logging_config/]()
