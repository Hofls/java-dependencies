Info:
* Easy application monitoring (with special prometheus endpoints!)
* Bunch of scripts that use actuator are in `useful-info` repository
* More info at `spring-boot-admin`

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

Endpoint activation example (in application.yaml):
```
management:
  endpoint:
    heapdump:
      enabled: true
  endpoints:
    web:
      exposure:
        include: health,info,heapdump

```