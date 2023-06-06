package hofls.com.github.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CustomExceptionConfig2 {

    @Bean
    public ErrorDecoder customExceptionDecoder2() {
        return (methodKey, response) -> {
            throw new RuntimeException("Wrong decoder!");
        };
    }
}
