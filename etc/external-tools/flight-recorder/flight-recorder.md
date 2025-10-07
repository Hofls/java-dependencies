### Java Flight Recorder (JFR) + Java Mission Control (JMC)
* Info:
  * Java Flight Recorder - records metrics during jar execution
  * Java Mission Control - visualizes metrics recorded by JFR
* Getting started:
  * Find any .jar file, for example [minimal-template](../../../project-templates/minimal/build/libs)
  * Run it with `flight recorder`:
      `java -XX:StartFlightRecording=duration=5s,filename=flight.jfr -jar minimal-project-0.0.1-SNAPSHOT.jar`
  * Download, unzip and launch [Mission Control](https://jdk.java.net/jmc/8/)
  * Open JMC, close welcome page, open file `flight.jfr`
