* Run `bootRun --args='--spring.profiles.active=to-file'`
    * Check file - `C:\var\log\example.log`
* Run `bootRun --args='--spring.profiles.active=to-console'`
    * Check console
* Run `bootRun --args='--spring.profiles.active=to-console-and-file'`
    * Check file and console
* Tips:
    * To check if file logback.xml is being used - clear its content
        * Error should appear - `Premature end of file`
    * 
* 
* 