package hofls.com.github.rest.same.name.types;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ResponseA {

    @Schema
    private Period period;

    @Data
    public static class Period {
        @Schema(description = "dateBegin from ResponseA")
        private LocalDate dateBegin;

        @Schema(description = "dateEnd from ResponseA")
        private LocalDate dateEnd;

    }
}
