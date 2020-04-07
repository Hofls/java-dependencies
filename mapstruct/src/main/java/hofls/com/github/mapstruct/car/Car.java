package hofls.com.github.mapstruct.car;

import hofls.com.github.mapstruct.passenger.Passenger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private String make;
    private int numberOfSeats;
    private ECarType type;
    private List<Passenger> passengers;
    private Integer someWeirdField;

}
