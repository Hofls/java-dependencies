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
* jmap -clstats 1 | grep Total
    * Class loader info (metaspace)
* jstat -gc 1
    * Garbage collector info
* Heap dump (has its own section)

# Outdated/Unpopular tech
* Java EE/Jakarta EE - alternative to Spring
* Ant - alternative to Maven/Gradle
* GWT - alternative to frontend
* Powermock - alternative to mockito
* Jetty/WebLogic/WildFly/JBoss - alternative to an embedded tomcat

# Dump
##### Get dump
* With actuator:
    * http://dps.k8s.someit.com/actuator/heapdump
* Directly:
    * Get PID:
        * `ps -aux | grep java`
    * Get dump:
        * `jmap -dump:format=b,file=dump.hprof INSERT_PID_HERE`
##### Analyze dump
* Download Eclipse Memory Analyzer (MAT)
    * https://www.eclipse.org/mat/
* In file `MemoryAnalyzer.ini` change default `-Xmx1024m` to `-Xmx4096m`
* Run analyzer, open dump
    * It will automatically show problems (e.g. memory leaks)
    * List the biggest objects - `Dominator Tree`
        * To see who references an object - `List incoming refereces`
        * To get full string - Attributes -> Right click -> Copy -> Value
    * Detect classes loaded multiple times - `Duplicate Classes` (metaspace leak)
##### Alternatives
* VisualVM
    * [Fix for typical launch problem](https://stackoverflow.com/questions/24044069/visualvm-running-jre/24044137)
    * Great for currently running apps, bad for dump analysis
    * Very slow leak analysis, weird list of classes (e.g. shows string, instead of class which contains it)

