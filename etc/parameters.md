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
