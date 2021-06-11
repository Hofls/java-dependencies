package hofls.com.github.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "custom.properties")
public class ConfigDemo {

    private String hello;

}