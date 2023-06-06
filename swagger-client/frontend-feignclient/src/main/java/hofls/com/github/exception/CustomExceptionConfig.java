package hofls.com.github.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CustomExceptionConfig {

    @Bean
    public ErrorDecoder customExceptionDecoder() {
        return (methodKey, response) -> {
            try {
                String responseBody = response.body().toString();
                CustomException.CustomExceptionData data = new ObjectMapper()
                        .readValue(responseBody, CustomException.CustomExceptionData.class);
                return new CustomException(data);
            } catch (Exception ignored) {
            }
            return new ErrorDecoder.Default().decode(methodKey, response);
        };
    }
}
