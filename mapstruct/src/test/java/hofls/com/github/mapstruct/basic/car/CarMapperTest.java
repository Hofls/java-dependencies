package hofls.com.github.mapstruct.basic.car;

import hofls.com.github.mapstruct.basic.passenger.Passenger;
import hofls.com.github.mapstruct.basic.passenger.PassengerDto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarMapperTest {

    @Test
    public void should_convert_entity_to_dto() {
        Passenger passenger = new Passenger("Donny", 23);
        Car car = new Car( "Morris", 5, ECarType.SEDAN, Arrays.asList(passenger), 56);

        CarDto carDto = CarMapper.INSTANCE.carToDto(car);

        assertEquals("Morris", carDto.getMake());
        assertEquals(5, carDto.getSeatCount());
        assertEquals("SEDAN", carDto.getType());
        assertEquals(new PassengerDto("Donny", 23), carDto.getPassengers().get(0));
    }

    @Test
    public void should_convert_dto_to_entity() {
        PassengerDto passengerDto = new PassengerDto("John", 34);
        CarDto carDto = new CarDto( "Volvo", 23, "BUS", Arrays.asList(passengerDto));

        Car car = CarMapper.INSTANCE.dtoToCar(carDto);

        assertEquals("Volvo", car.getMake());
        assertEquals(23, car.getNumberOfSeats());
        assertEquals(ECarType.BUS, car.getType());
        assertEquals(new Passenger("John", 34), car.getPassengers().get(0));
    }

}
