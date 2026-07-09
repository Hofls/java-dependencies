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
