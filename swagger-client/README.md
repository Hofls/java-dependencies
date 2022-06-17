# Swagger backend + client

#### Notice:
* `backend-springfox` is kinda dead, better use `backend-springdoc`

#### Run backend
* Look at `README.md` in backend folder

#### Generate REST client (or use generated in `frontend` package)
* Installation:
    * [Download file](http://central.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.5/swagger-codegen-cli-2.4.5.jar)
    * Move file to folder `%USERPROFILE%\swagger-codegen-cli\`
    
* Code generation:
```
java -jar %USERPROFILE%\swagger-codegen-cli\swagger-codegen-cli-2.4.5.jar generate ^
  -i http://localhost:8080/v2/api-docs?group=default ^
  -l java ^
  -o %USERPROFILE%/Desktop/swagger-client
```
Generated code will appear on the desktop, inside `swagger-rest-client` folder

#### Run `frontend` tests
