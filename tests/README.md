# java-tests
## All kinds of tests:
* common:
    * arch unit - automatically enforce project architecture on developers
    * mock test - mock external dependencies (without mocks - integration test. with mocks - unit test) 
    * unit test - simplest test, just one unit
    * unit test exception - make sure that code throws exception
    * unit test multithreaded - make sure that code can work in multiple threads
    * unit test parameterized - call same test with different parameters
    * `pitest` - runs mutation tests, to make sure that code is fully tested
        * to run manually - `gradlew pitest`
        * full report is located in folder `build/reports/pitest/index.html`
* database-container:
    * db tests with postgress running inside docker container (based on .sh scripts)
* rest-tests:
    * end-to-end tests with `WebTestClient`
* test-containers:
    * db tests with postgress running inside docker container (based on framework)
* tests-generation:
    * squaretest - is very good, but there is no free version
    * testme - is almost as good as squaretest + its free!
        * When used with plugin `GenerateAllSetter` - becomes just as good as squaretest
* others:
    * jacoco - generate code coverage report
