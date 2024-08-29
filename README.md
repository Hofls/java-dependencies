# JDK
* Default - [Adoptium (Temurin)](https://adoptium.net/temurin/releases/)
* Other - [OpenJDK (Oracle)](https://jdk.java.net/)

# JVM
* `HotSpot` - default
* `GraalVM` - good for serverless computing (50x faster startup, 5x smaller footprint)
* `Openj9` - good for cloud (2x faster startup, 2x smaller footprint)

# GC
* `G1 Collector` - default (java 9+)
* `Parallel GC` - default (before java 9)
* `ZGC` - low pause times, good for large heap sizes (up to 4 terabytes)
* `Shenandoah` - low pause times, good for large heap sizes 

# Parameters
* `-XX:-OmitStackTraceInFastThrow`
    * Without this parameter, some exceptions would have no stacktrace. Which makes them very hard to debug.
* Memory:
    * Absolute:
        * `–Xms256m` - initial heap size
        * `–Xmx1024m` - maximum heap size
    * Relative:
        * `-XX:MaxRAMPercentage=80.0` - use up to 80% of RAM as heap
* `-Duser.timezone=Asia/Tokyo` - timezone
* `-Dhttp.proxyHost=23.221.54.132 -Dhttp.proxyPort=3128 -Dhttp.nonProxyHosts="localhost|*.example.com"` - proxy

# Dependency alternatives
* `Spring` - micronaut, quarkus
    * Lose spring ecosystem, but gain fast startup time and low resources consumption (very niche)

# RAM
* `Heap` - java objects
    * `Young/Eden` - new objects
    * `Old/Tenured` - old objects
    * Garbage collector removes not referenced objects from heap
    * Can leak if you use a lot of heavy objects (e.g. endlessly filling up static list)
* `Metaspace` - class definitions
    * Uses native memory
    * Can leak if you continuously generate new classes, [example](https://stackoverflow.com/questions/44830943/metaspace-memory-leak)

# Resources usage
* http://dps.k8s.someit.com/actuator/metrics
    * `jvm.gc.live.data.size` `jvm.gc.max.data.size` `jvm.memory.committed` `jvm.memory.used`
* http://dps.k8s.someit.com/actuator/prometheus
    * `jvm_memory_committed_bytes` `jvm_memory_used_bytes` `jvm_memory_max_bytes`
* Class loader info (metaspace)
  * `jmap -clstats 1 | grep Total`
* Garbage collector info
  * `jstat -gc 1`
* Overall RAM usage
  * `ps aux  | awk '{print $6/1024 " MB\t\t" $11}'  | sort -n`
* Heap dump (has its own section at `external-tools/memory-analyzer`)
* `Command not found` fix:
  ```
  echo $JAVA_HOME
  cd /usr/java/jdk-21.0.4+7/bin
  ./jmap -clstats 1 | grep Total
  ./jstat -gc 1
  ```

# Outdated/Unpopular tech
* Java EE/Jakarta EE - alternative to Spring
* Ant - alternative to Maven/Gradle
* GWT - alternative to frontend
* Powermock - alternative to mockito
* Jetty/WebLogic/WildFly/JBoss - alternative to an embedded tomcat

# Etc
* REPL (Read-eval-print loop) - `jshell`