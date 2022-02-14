package hofls.com.github.rest.parameters.types;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ParametersInBody {

    @Schema(description = "Nothing special", example = "1988-02-21")
    private LocalDate localDate;

    @Schema(description = "If you use single quotes, client wont be generated", example = "[\"Football\",\"Music\"]")
    private List<String> hobbies;

}
