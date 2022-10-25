package hofls.com.github.rest.api.example.types;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class Human {
    @ApiModelProperty(value = "Full name of a person", example = "John St Junior")
    private String name;
    @ApiModelProperty(value = "Main profession", example = "Blacksmith")
    private String profession;
    @ApiModelProperty(value = "Objects of profound interest", example = "[\"Football\",\"Music\"]")
    private List<String> hobbies;
}
