#### How to run:
* Run `bootRun`
* Open URL - http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config

#### Weird stuff:
* LocalTime:
    * Must add to Docket:
    ```
    .directModelSubstitute(LocalTime.class, String.class)
    ```
    * So LocalTime will work:
    ```
    @Schema(example = "[\"12:30\", \"21:00\"]")
    private List<LocalTime> times;
    ```
* 
