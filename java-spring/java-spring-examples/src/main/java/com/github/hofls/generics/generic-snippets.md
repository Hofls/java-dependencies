* Method parameters. Restrictive vs flexible:
    ```
    // Restrictive. Only accepts lists of those exact types:
    public static void validate(List<ICommonQuestion> questions, List<ICommonAnswer> answers) {}
    
    // Flexible, accepts lists of any implementation classses:
    public static <T extends ICommonQuestion, R extends ICommonAnswer> void validate(List<T> questions, List<R> answers) {]
    ```
