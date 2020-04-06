package hofls.com.github.rest.errors;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NotNull;

@Data
public class ObjectInPath {
    @NotNull
    @Negative
    @ApiModelProperty(example="17")
    private Long fieldA;

    @Max(55)
    @NotNull
    @ApiModelProperty(example="100")
    private Integer fieldB;
}
