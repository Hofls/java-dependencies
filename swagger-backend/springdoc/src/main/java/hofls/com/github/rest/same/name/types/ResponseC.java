package hofls.com.github.rest.same.name.types;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ResponseC {

    @Schema
    private Period period;

    @Data
    @Schema(name = "MainPeriod")
    public static class Period {
        @Schema(description = "periodStart from ResponseC")
        private LocalDate periodStart;

        @Schema(description = "periodEnd from ResponseC")
        private LocalDate periodEnd;

    }
}
