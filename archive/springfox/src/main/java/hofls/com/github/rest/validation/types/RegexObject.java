package hofls.com.github.rest.validation.types;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class RegexObject {

    @Pattern(regexp = "[0-9]{7,12}")
    @ApiModelProperty(example="123456")
    private String phoneNumber;
}
