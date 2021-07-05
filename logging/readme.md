* To debug logs:
    * `System.out.println()` -> `Writer.write` -> Set breakpoint
    * Breakpoint will be activated on logs write
* How to find logs packages, figure out logging levels?
    * Set `DEBUG` level for ALL logs, run app, look at logs, figure out what you need
    ```
  	<root level="DEBUG">
  		<appender-ref ref="FILE_APPENDER" />
  	</root>
    ```
