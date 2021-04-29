* @RequiredArgsConstructor
    ```
    @Repository
    @RequiredArgsConstructor // Alternative to @Autowirred, ignores non final fields
    public class CarRepository {
        private final CarContext service;
        private final ExceptionHandler exceptionHandler;
        @Resource(mappedName = "someRole")
        private String lastRoleId;
    }
    ```
* @AllArgsConstructor
    ```
      @Repository
      @AllArgsConstructor // Alternative to @Autowirred
      public class CarRepository {
          private final CarContext service;
          private final ExceptionHandler exceptionHandler;
      }
    ```
