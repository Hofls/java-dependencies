package hofls.com.github.rest.parameters.types;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
public class ParametersInQuery {

    @Schema(description = "In path only with @DateTimeFormat", example = "1988-02-21")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate localDate;

    @Schema(description = "If you use single quotes, client wont be generated", example = "[\"Football\",\"Music\"]")
    private List<String> hobbies;
}
