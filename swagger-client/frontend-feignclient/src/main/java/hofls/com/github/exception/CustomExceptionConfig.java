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
                return new ObjectMapper().readValue(responseBody, CustomException.class);
            } catch (Exception ignored) {
            }
            return new ErrorDecoder.Default().decode(methodKey, response);
        };
    }
}
