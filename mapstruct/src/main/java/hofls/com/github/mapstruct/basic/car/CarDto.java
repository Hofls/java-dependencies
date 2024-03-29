package hofls.com.github.mapstruct.basic.car;

import hofls.com.github.mapstruct.basic.passenger.PassengerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private String make;
    private int seatCount;
    private String type;
    private List<PassengerDto> passengers;
}
