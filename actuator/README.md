Easy application monitoring (with special prometheus endpoints!)

To run:
* Execute `bootRun`
* Open [link](http://localhost:8099/actuator)

Useful endpoints:
* [Info](http://localhost:8099/actuator/info)
    * Thanks to `gradle-git-properties` plugin
* [Environment](http://localhost:8099/actuator/env)
* [Properties](http://localhost:8099/actuator/configprops)
* [Heap dump](http://localhost:8099/actuator/heapdump)
* [Metrics](http://localhost:8099/actuator/metrics)
* [Specific metric](http://localhost:8099/actuator/metrics/system.cpu.usage)
* [REST/SOAP endpoints](http://localhost:8099/actuator/mappings)
* [For Prometheus](http://localhost:8099/actuator/prometheus)

