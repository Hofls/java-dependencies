package hofls.com.github.rest.common.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private final CustomExceptionData customExceptionData;

    public CustomException(String errorCode, String errorDescription) {
        this.customExceptionData = new CustomExceptionData(errorCode, errorDescription);
    }

    @Data
    @AllArgsConstructor
    public static class CustomExceptionData {
        private final String errorCode;
        private final String errorDescription;
    }

}
