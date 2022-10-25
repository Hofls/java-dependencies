package hofls.com.github.rest.parameters.types;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class ParametersInBody {

    @Schema(description = "Nothing special", example = "1988-02-21")
    private LocalDate localDate;

    @Schema(description = "If you use single quotes, client wont be generated", example = "[\"Football\",\"Music\"]")
    private List<String> hobbies;

    @Schema(example = "[\"12:30\", \"21:00\"]")
    private List<LocalTime> times;

}
