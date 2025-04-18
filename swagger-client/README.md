### Swagger backend + client
* Run backend [README.md](backend-springdoc/README.md)
* Generate REST client (or use generated in `frontend` package)
* Code generation:
  * [Download jar file](https://mvnrepository.com/artifact/io.swagger.codegen.v3/swagger-codegen-cli/3.0.68)
  * Put file in a `codegen-test` folder, open CLI there
  * Find swagger endpoint that produces JSON description (with paths, parameters, tags, responses etc)
  * Execute command:
  ```
  java -jar swagger-codegen-cli-3.0.68.jar generate ^
    -i http://localhost:8080/v3/api-docs ^
    -l java ^
    -o . ^
    --additional-properties hideGenerationTimestamp=true
  ```
  * Optional - convert LF to CRLF in all generated files (via PowerShell):
  ```
  Get-ChildItem -Recurse -File | ForEach-Object {
      (Get-Content $_.FullName -Raw) -replace "`n", "`r`n" | Set-Content $_.FullName -NoNewline
  }
  ```
* Run `frontend` tests

