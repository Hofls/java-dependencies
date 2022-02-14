package hofls.com.github.rest.api.example.types;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class HumanFilter {
    @Schema(description = "Full name of a person")
    private List<String> names;
    @Schema(description = "Main profession")
    private List<String> professions;
}
