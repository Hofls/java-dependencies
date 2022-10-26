package hofls.com.github.mapstruct.basic.car;

import hofls.com.github.mapstruct.basic.passenger.PassengerMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, unmappedSourcePolicy = ReportingPolicy.ERROR,
        uses = { PassengerMapper.class })
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );

    @Mapping(source = "seatCount", target = "numberOfSeats")
    @Mapping(target = "someWeirdField", ignore = true)
    Car dtoToCar(CarDto carDto);

    @BeanMapping(ignoreUnmappedSourceProperties = "someWeirdField")
    @InheritInverseConfiguration
    CarDto carToDto(Car car);

}