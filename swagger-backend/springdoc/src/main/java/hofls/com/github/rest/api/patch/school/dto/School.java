package hofls.com.github.rest.api.patch.school.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

// In real project this class will be a DB entity (@Table)
@Data
public class School {

    private String address;

    private Long studentsCount;

    private List<SKEUnit> skeUnits;

    @Data
    public static class SKEUnit {
        private Long id;

        private Boolean active;
    }

}
