# Parameters
* TLDR - Good parameters for java 25+
  * `-XX:InitialRAMPercentage=30.0 -XX:MaxRAMPercentage=60.0 -XX:MaxMetaspaceSize=256m -XX:+UseCompactObjectHeaders -XX:+UseSerialGC`
* Insane defaults - Java uses only 25% of available RAM as heap, even in docker/k8s
    * Absolute fix:
        * `–Xms256m` - initial heap size
        * `–Xmx1024m` - maximum heap size
    * Relative fix:
        * `-XX:InitialRAMPercentage=30.0 -XX:MaxRAMPercentage=60.0` - dynamically use from 35% to 70% of RAM as heap
    * Always leave some free RAM (20-30%), java will use it for:
      * Metaspace - where class definitions are stored
      * Thread Stacks - every thread takes memory (usually 1 MB per thread)
      * Off-Heap/Direct Memory - used by high-performance network frameworks like Netty
      * Garbage Collection (GC) overhead
* Some exceptions have no stacktrace (hard to debug). Fix:
    * `-XX:-OmitStackTraceInFastThrow`
* Set timezone:
  * `-Duser.timezone=Asia/Tokyo`
* Use proxy:
  * Http: `-Dhttp.proxyHost=23.221.54.132 -Dhttp.proxyPort=3128 -Dhttp.nonProxyHosts="localhost|*.example.com"`
  * Https: `-Dhttps.proxyHost=23.221.54.132 -Dhttps.proxyPort=3128 -Dhttps.nonProxyHosts="localhost|*.example.com"`
