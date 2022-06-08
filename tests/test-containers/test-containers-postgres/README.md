#### Run build+tests in Docker (dind alternative)
* Preparations:
    * Prerequisites - installed Docker
    * Copy this directory to server, open it
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
