package hofls.com.github.rest.api.patch.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
public class GameCardPatch {
    @Schema(description = "Name", example = "Jake")
    private String name;

    @Schema(description = "Game points", example = "0")
    private String points;

    @Schema(description = "Date", example = "2023-04-18")
    private String date;

    @Schema(description = "Add marks")
    private List<Mark> addMarks;

    @Schema(description = "Edit marks")
    private List<Mark> editMarks;

    @Schema(description = "Delete marks")
    private List<Mark> deleteMarks;

    @Data
    public static class Mark {
        @Schema(description = "id", example = "5c8c258d-35fb-4500-bc46-57b592209c2c")
        private String id;

        @Schema(description = "Time", example = "09:45")
        private String time;

        @Schema(description = "Value", example = "177.42")
        private String value;
    }

}
