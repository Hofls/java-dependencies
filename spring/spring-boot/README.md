##### More
For more info, look at `java-spring` folder

##### Problems
Latest spring-boot version forks process, which breaks `Debug` mode (breakpoints), process may refuse to stop running.
    * Fix: `clean spring-boot:run -Dspring-boot.run.fork=false`


##### Useful annotations:
* `spring-boot-starter`
    * `@EntityScan` - extra packages to search for @Entity classes (hibernate)
* `spring-context`
    * `@ComponentScan` - extra packages to search for beans, spring adds them to context (allowing them to be @Autowired)