package hofls.com.github.rest.responses.types;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ResponseC {

    @ApiModelProperty
    private Period period;

    @Data
    @ApiModel("ResponseC.Period")
    public static class Period {
        @ApiModelProperty(value = "periodStart from ResponseC")
        private LocalDate periodStart;

        @ApiModelProperty(value = "periodEnd from ResponseC")
        private LocalDate periodEnd;

    }
}
