### Controversial
* `var`
  * Everybody agrees that `var user = new User()` is better than `User user = new User();`
  * Some people say that hiding type is bad - `var user = findUser(id)`, and then turn around and write method chains:
    * `repository.findUser().getAccount().getNickname();`
  * Aligns with overall dev trends (all main programming languages widely use var)

### Ideas
* Generate code straight to the `target` folder
  * No need for anything fancy - just scan folder for text files, read them, then use StringBuilder and save result to a new file
  * Example - in facade/bff, for each @FeignClient, generate @RestController

### Refactoring
* Find 100 biggest classes (to break them up): \
  `find . -type f -exec du -h {} + | sort -rh | head -n 100`

### Etc
* REPL (Read-eval-print loop) - `jshell`

### JDK
* Default - [Adoptium (Temurin)](https://adoptium.net/temurin/releases/)
* Other - [OpenJDK (Oracle)](https://jdk.java.net/)

### JVM
* `HotSpot` - default
* `GraalVM` - good for serverless computing (50x faster startup, 5x smaller footprint)
* `Openj9` - good for cloud (2x faster startup, 2x smaller footprint)

### GC
* `G1 Collector` - default (java 9+)
* `Parallel GC` - default (before java 9)
* `ZGC` - low pause times, good for large heap sizes (up to 4 terabytes)
* `Shenandoah` - low pause times, good for large heap sizes

### Dependency alternatives
* `Spring` - micronaut, quarkus, helidon
  * Lose spring ecosystem, but gain fast startup time and low resources consumption (very niche)

### RAM
* `Heap` - java objects
  * `Young/Eden` - new objects
  * `Old/Tenured` - old objects
  * Garbage collector removes not referenced objects from heap
  * Can leak if you use a lot of heavy objects (e.g. endlessly filling up static list)
* `Metaspace` - class definitions
  * Uses native memory
  * Can leak if you continuously generate new classes, [example](https://stackoverflow.com/questions/44830943/metaspace-memory-leak)
