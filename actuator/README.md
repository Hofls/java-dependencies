Easy application monitoring (with special prometheus endpoints!)

To run:
* Execute `bootRun`
* Open [link](http://localhost:8080/actuator)

Useful endpoints:
* [Environment](http://localhost:8080/actuator/env)
* [Properties](http://localhost:8080/actuator/configprops)
* [Heap dump](http://localhost:8080/actuator/heapdump)
* [Metrics](http://localhost:8080/actuator/metrics)
* [Specific metric](http://localhost:8080/actuator/metrics/system.cpu.usage)
* [REST/SOAP endpoints](http://localhost:8080/actuator/mappings)
* [For Prometheus](http://localhost:8080/actuator/prometheus)
