package hofls.com.github.rest.responses.types;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ResponseB {

    @ApiModelProperty
    private Period period;

    @Data
    public static class Period {
        @ApiModelProperty(value = "start from ResponseB")
        private LocalDate start;

        @ApiModelProperty(value = "end from ResponseB")
        private LocalDate end;

    }
}
