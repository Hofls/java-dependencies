package hofls.com.github.mapstruct.common;

import org.mapstruct.MapperConfig;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

// Usage example - @Mapper(config = CommonMapperConfig.class)
@MapperConfig(
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public class CommonMapperConfig {
}
