# Swagger backend + client

#### Notice:
* `backend-springfox` is kinda dead, better use `backend-springdoc`

#### Run backend
* Look at `README.md` in backend folder

#### Generate REST client (or use generated in `frontend` package)
* Installation:
    * [Download jar file](https://mvnrepository.com/artifact/io.swagger.codegen.v3/swagger-codegen-cli/3.0.68)
    * Put file in a `codegen-test` folder
    
* Code generation:
  * Open CLI in a `codegen-test` folder
  * Execute command:
  ```
  java -jar swagger-codegen-cli-3.0.68.jar generate ^
    -i http://api.tpehrdb.m15.dzm/v2/api-docs ^
    -l java ^
    -o .
  ```

#### Run `frontend` tests
