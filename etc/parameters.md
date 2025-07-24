# Parameters
* Insane defaults - Java uses only 25% of available RAM, even in docker/k8s. Fix:
    * Absolute:
        * `–Xms256m` - initial heap size
        * `–Xmx1024m` - maximum heap size
    * Relative:
        * `-XX:InitialRAMPercentage=35.0 -XX:MaxRAMPercentage=70.0` - dynamically use from 35% to 70% of RAM as heap
* Some exceptions have no stacktrace (hard to debug). Fix:
    * `-XX:-OmitStackTraceInFastThrow`
* Set timezone:
  * `-Duser.timezone=Asia/Tokyo`
* Use proxy:
  * Http: `-Dhttp.proxyHost=23.221.54.132 -Dhttp.proxyPort=3128 -Dhttp.nonProxyHosts="localhost|*.example.com"`
  * Https: `-Dhttps.proxyHost=23.221.54.132 -Dhttps.proxyPort=3128 -Dhttps.nonProxyHosts="localhost|*.example.com"`
