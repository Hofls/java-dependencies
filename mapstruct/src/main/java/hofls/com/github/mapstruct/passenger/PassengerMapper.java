package hofls.com.github.mapstruct.passenger;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, unmappedSourcePolicy = ReportingPolicy.ERROR,
        uses = { DateUtils.class })
public interface PassengerMapper {

    PassengerMapper INSTANCE = Mappers.getMapper( PassengerMapper.class );

    @Mapping(source = "name", target = "fullName")
    @Mapping(source = "age", target = "totalAge")
    Passenger dtoToPassenger(PassengerDto dto);

    @InheritInverseConfiguration
    PassengerDto passengerToDto(Passenger passenger);

}