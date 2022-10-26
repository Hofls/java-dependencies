package hofls.com.github.mapstruct.misc;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

// To hide methods use "mapper abstract class"
@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    // Should be one method to fully convert objects (calling multiple methods to convert = high complexity)
    UserDto oneTrueMethod(User user, List<Privilege> privileges);

    void copyProperties(User source, @MappingTarget UserDto target);

    @Mapping(target = "city", source = ".", qualifiedByName = "setCity")
    UserDto toDto(User user);

    @Named("setCity")
    default String setCity(User user) {
        return "New York";
    }

}