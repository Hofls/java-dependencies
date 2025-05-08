# Basic auth
* `Basic auth` - Each request should contain header with login and password (encoded with base64)
  * Something like `Authorization: Basic TWlueDo0MzIx`
* To run locally - `gradlew bootRun` 
    * Then open link in the browser [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
* Call each method (on protected method call, `Sign in` window should appear) 