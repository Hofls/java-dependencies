package hofls.com.github.rest.same.name.types;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ResponseB {

    @Schema
    private Period period;

    @Data
    public static class Period {
        @Schema(description = "start from ResponseB")
        private LocalDate start;

        @Schema(description = "end from ResponseB")
        private LocalDate end;

    }
}
