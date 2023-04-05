package hofls.com.github.rest.api.patch.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class GameCard {
    @Schema(description = "Name", example = "Jake")
    private String name;

    @Schema(description = "Game points", example = "0")
    private String points;

    @Schema(description = "Date", example = "2023-04-18")
    private String date;
}
