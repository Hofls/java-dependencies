package hofls.com.github.mapstruct.basic.passenger;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PassengerDto {

    private String name;
    private int age;
    private LocalDateTime registrationDateTime;

    public PassengerDto(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
