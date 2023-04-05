package hofls.com.github.rest.api.patch.game.card.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

// In real project this class will be a DB entity (@Table)
@Data
public class GameCard {
    private String name;

    private Long points;

    private LocalDate date;
    private List<Mark> marks;

    @Data
    public static class Mark {
        private UUID id;

        private LocalTime time;

        private Double value;
    }

}
