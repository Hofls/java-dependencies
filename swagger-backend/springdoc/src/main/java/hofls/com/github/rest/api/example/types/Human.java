package hofls.com.github.rest.api.example.types;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class Human {
    @Schema(description = "Full name of a person", example = "John St Junior")
    private String name;
    @Schema(description = "Main profession", example = "Blacksmith")
    private String profession;
    @Schema(description = "Objects of profound interest", example = "[\"Football\",\"Music\"]")
    private List<String> hobbies;
}
