package hofls.com.github.rest.api.patch.school.dto;

import hofls.com.github.rest.api.patch.common.Identifiable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

// In real project this class will be a DB entity (@Table)
@Data
public class School {

    private String address;

    private Long studentsCount;

    private List<SKEUnit> skeUnits;

    @Data
    public static class SKEUnit implements Identifiable {
        private UUID id;

        private LocalDate date;

        private Boolean active;
    }

}
