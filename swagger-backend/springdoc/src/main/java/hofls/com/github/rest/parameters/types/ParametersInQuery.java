package hofls.com.github.rest.parameters.types;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Data
public class ParametersInQuery {

    @Schema(description = "In path only with @DateTimeFormat", example = "1988-02-21")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // If you dont want to spam this annotation on each date field - uncomment class WebConfig
    private LocalDate localDate;

    @Schema(description = "In path only with @DateTimeFormat", example = "2022-08-19T08:00")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) // If you dont want to spam this annotation on each date field - uncomment class WebConfig
    private LocalDateTime localDateTime;

    @Schema(description = "In path only with @DateTimeFormat", example = "2023-09-18T10:15:30+03:00")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) // If you dont want to spam this annotation on each date field - uncomment class WebConfig
    private OffsetDateTime offsetDateTime;

    @Schema(description = "If you use single quotes, client wont be generated", example = "[\"Football\",\"Music\"]")
    private List<String> hobbies;
}
