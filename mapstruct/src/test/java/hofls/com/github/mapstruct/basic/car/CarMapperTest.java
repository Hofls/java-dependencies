package hofls.com.github.mapstruct.basic.car;

import hofls.com.github.mapstruct.basic.passenger.Passenger;
import hofls.com.github.mapstruct.basic.passenger.PassengerDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CarMapperTest {

    @Test
    public void should_convert_entity_to_dto() {
        Passenger passenger = new Passenger("Donny", 23);
        Car car = new Car( "Morris", 5, ECarType.SEDAN, Arrays.asList(passenger), 56);

        CarDto carDto = CarMapper.INSTANCE.carToDto(car);

        Assert.assertEquals("Morris", carDto.getMake());
        Assert.assertEquals(5, carDto.getSeatCount());
        Assert.assertEquals("SEDAN", carDto.getType());
        Assert.assertEquals(new PassengerDto("Donny", 23), carDto.getPassengers().get(0));
    }

    @Test
    public void should_convert_dto_to_entity() {
        PassengerDto passengerDto = new PassengerDto("John", 34);
        CarDto carDto = new CarDto( "Volvo", 23, "BUS", Arrays.asList(passengerDto));

        Car car = CarMapper.INSTANCE.dtoToCar(carDto);

        Assert.assertEquals("Volvo", car.getMake());
        Assert.assertEquals(23, car.getNumberOfSeats());
        Assert.assertEquals(ECarType.BUS, car.getType());
        Assert.assertEquals(new Passenger("John", 34), car.getPassengers().get(0));
    }

}
