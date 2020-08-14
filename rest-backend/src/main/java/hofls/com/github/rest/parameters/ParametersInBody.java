package hofls.com.github.rest.parameters;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ParametersInBody {

    @ApiModelProperty(value = "Nothing special", example = "1988-02-21")
    private LocalDate localDate;

}
