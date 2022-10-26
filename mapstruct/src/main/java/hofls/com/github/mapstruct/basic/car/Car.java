package hofls.com.github.mapstruct.basic.car;

import hofls.com.github.mapstruct.basic.passenger.Passenger;
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
