package hofls.com.github.rest.api.patch.game.dto;

import hofls.com.github.rest.api.patch.common.Identifiable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

// In real project this class will be stored in a database (e.g. as jsonb)
@Data
public class Game {
    private String name;

    private Long points;

    private LocalDate date;

    private List<Mark> marks;

    private List<Integer> positions;

    @Data
    public static class Mark implements Identifiable {
        private UUID id;

        private LocalTime time;

        private Double value;
    }

}
