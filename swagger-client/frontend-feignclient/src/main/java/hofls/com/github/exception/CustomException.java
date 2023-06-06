package hofls.com.github.exception;

public class CustomException extends RuntimeException {

    private CustomExceptionData customExceptionData = new CustomExceptionData();

    public CustomException() {
    }

    public void setErrorCode(String errorCode) {
        this.customExceptionData.errorCode = errorCode;
    }

    public void setErrorDescription(String errorDescription) {
        this.customExceptionData.errorDescription = errorDescription;
    }

    public CustomException(String errorCode, String errorDescription) {
        this.customExceptionData = new CustomExceptionData(errorCode, errorDescription);
    }

    public CustomExceptionData getCustomExceptionData() {
        return customExceptionData;
    }

    public static class CustomExceptionData {
        private String errorCode;
        private String errorDescription;

        public CustomExceptionData(String errorCode, String errorDescription) {
            this.errorCode = errorCode;
            this.errorDescription = errorDescription;
        }

        public CustomExceptionData() {
        }

        public String getErrorCode() {
            return errorCode;
        }

        public String getErrorDescription() {
            return errorDescription;
        }
    }

}
