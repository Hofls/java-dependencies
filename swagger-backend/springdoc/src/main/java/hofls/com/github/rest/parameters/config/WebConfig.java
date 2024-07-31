package hofls.com.github.rest.parameters.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;

import java.time.format.DateTimeFormatter;

// Uncomment if you need a great alternative to @DateTimeFormat:
// @Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
        registrar.setDateFormatter(DateTimeFormatter.ISO_DATE);
        registrar.setDateTimeFormatter(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        registrar.registerFormatters(registry);
    }
}
