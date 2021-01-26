
##### Problems
Latest spring-boot version forks process, which breaks `Debug` mode (breakpoints), process may refuse to stop running.
    * Fix: `clean spring-boot:run -Dspring-boot.run.fork=false`
