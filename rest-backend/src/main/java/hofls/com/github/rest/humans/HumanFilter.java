package hofls.com.github.rest.humans;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class HumanFilter {
    @ApiModelProperty(value = "Full name of a person")
    private List<String> names;
    @ApiModelProperty(value = "Main profession")
    private List<String> professions;
}
