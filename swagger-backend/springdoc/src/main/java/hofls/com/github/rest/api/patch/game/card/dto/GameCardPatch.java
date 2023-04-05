package hofls.com.github.rest.api.patch.game.card.dto;

import hofls.com.github.rest.api.patch.common.PatchOperation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class GameCardPatch {
    @Schema(description = "Name", example = "Jake")
    private String name;

    @Schema(description = "Game points", example = "0")
    private String points;

    @Schema(description = "Date", example = "2023-04-18")
    private String date;

    @Schema(description = "Marks")
    private List<Mark> marks;

    @Data
    public static class Mark {
        @Schema(description = "id", example = "5c8c258d-35fb-4500-bc46-57b592209c2c")
        private String id;

        @Schema(description = "Time", example = "09:45")
        private String time;

        @Schema(description = "Value", example = "177.42")
        private String value;

        @Schema(description = "PATCH operation", example = "REPLACE")
        private PatchOperation operation;
    }

}
