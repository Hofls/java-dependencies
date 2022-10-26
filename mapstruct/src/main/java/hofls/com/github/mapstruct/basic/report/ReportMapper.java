package hofls.com.github.mapstruct.basic.report;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ReportMapper {

    ReportMapper INSTANCE = Mappers.getMapper( ReportMapper.class );

    @Mappings({
            @Mapping(target = "showPageNumber", source = "footerSettings.showPageNumber"),
            @Mapping(target = "showHeader", source = "headerSettings.showLogo")
    })
    Parameters reportToParameters(Report report);

    @InheritInverseConfiguration
    Report parametersToReport(Parameters parameters);

}
