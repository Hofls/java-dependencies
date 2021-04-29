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
    * To see who references an object - `List incoming refereces`
    * To get full string - Attributes -> Rightclick -> Copy -> Value

##### Alternatives
* VisualVM
    * [Fix for typical launch problem](https://stackoverflow.com/questions/24044069/visualvm-running-jre/24044137)
    * Great for currently running apps, bad for dump analysis
    * Very slow leak analysis, weird list of classes (e.g. shows string, instead of class which contains it)
