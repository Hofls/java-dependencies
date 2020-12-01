package hofls.com.github.rest.parameters.types;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
public class ParametersInPath {

    @ApiModelProperty(value = "In path only with @DateTimeFormat", example = "1988-02-21")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate localDate;

    @ApiModelProperty(value = "Not working. TODO: figure this out", example = "[\"Football\",\"Music\"]")
    private List<String> hobbies;
}
