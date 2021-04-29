##### Get dump
* Get PID:
    * `ps -aux | grep java`
* Get dump:
    * `jmap -dump:format=b,file=dump.hprof INSERT_PID_HERE`

##### Analyze dump
* Download Memory Analyzer (MAT)
    * https://www.eclipse.org/mat/
* In file `MemoryAnalyzer.ini` change default `-Xmx1024m` to `-Xmx4096m`
* Run analyzer, open dump
    * It will automatically show problems (e.g. memory leaks)
