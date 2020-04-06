package hofls.com.github.rest.humans;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Human {
    @ApiModelProperty(value = "Full name of a person", example = "John St Junior")
    private String name;
    @ApiModelProperty(value = "Main profession", example = "Blacksmith")
    private String profession;
}
