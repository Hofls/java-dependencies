package hofls.com.github.rest.api.patch.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
public class GameCard {
    @Schema(description = "Name", example = "Jake")
    private String name;

    @Schema(description = "Game points", example = "0")
    private Long points;

    @Schema(description = "Date", example = "2023-04-18")
    private LocalDate date;

    @Schema(description = "Marks")
    private List<Mark> marks;

    @Data
    public static class Mark {
        @Schema(description = "id", example = "5c8c258d-35fb-4500-bc46-57b592209c2c")
        private UUID id;

        @Schema(description = "Time", example = "09:45")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
        private LocalTime time;

        @Schema(description = "Value", example = "177.42")
        private Double value;
    }

}
