package hofls.com.github.rest.responses.types;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ResponseA {

    @ApiModelProperty
    private Period period;

    @Data
    public static class Period {
        @ApiModelProperty(value = "dateBegin from ResponseA")
        private LocalDate dateBegin;

        @ApiModelProperty(value = "dateEnd from ResponseA")
        private LocalDate dateEnd;

    }
}
