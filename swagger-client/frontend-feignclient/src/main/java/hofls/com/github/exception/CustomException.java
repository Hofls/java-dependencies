package hofls.com.github.exception;

public class CustomException extends RuntimeException {

    private CustomExceptionData data;

    public CustomException(CustomExceptionData data) {
        this.data = data;
    }

    public CustomExceptionData getData() {
        return data;
    }

    public static class CustomExceptionData {
        public String errorCode; // or user private and @Data
        public String errorDescription;

        public CustomExceptionData(String errorCode, String errorDescription) {
            this.errorCode = errorCode;
            this.errorDescription = errorDescription;
        }

        public CustomExceptionData() {}
    }

}
