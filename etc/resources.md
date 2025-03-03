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
