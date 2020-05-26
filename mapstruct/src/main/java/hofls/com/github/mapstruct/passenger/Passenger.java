package hofls.com.github.mapstruct.passenger;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Passenger {

    private String fullName;
    private int totalAge;
    Date registrationDateTime;

    public Passenger(String fullName, int totalAge) {
        this.fullName = fullName;
        this.totalAge = totalAge;
    }
}
