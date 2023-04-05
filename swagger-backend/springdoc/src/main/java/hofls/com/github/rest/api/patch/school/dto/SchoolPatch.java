package hofls.com.github.rest.api.patch.school.dto;

import hofls.com.github.rest.api.patch.common.IPatch;
import hofls.com.github.rest.api.patch.common.PatchOperation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SchoolPatch {

    @Schema(description = "Address", example = "St.Bernard 53")
    private String address;

    @Schema(description = "Students count", example = "342")
    private String studentsCount;

    @Schema(description = "SKE units")
    private List<SKEUnit> skeUnits;

    @Data
    public static class SKEUnit implements IPatch {
        @Schema(description = "Id", example = "736168")
        private String id;

        @Schema(description = "Active", example = "true")
        private String active;

        @Schema(description = "Date", example = "2023-04-18")
        private String date;

        @Schema(description = "PATCH operation", example = "REPLACE")
        private PatchOperation operation;

    }

}
