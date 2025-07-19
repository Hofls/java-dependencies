### Snippets
* No need to specify full path to `UUID` package in `expression`:
```
@Mapper(config = CommonMapperConfig.class, imports = { UUID.class })
public abstract class WaterPrescriptionMapper {
  @Mapping(target = "userId", expression = "java(UUID.fromString(userDto.getStringId))")
  public abstract User toDto(UserDto userDto);
}
```
* Why complex `expression = "java(..)"` is bad:
  * There is no autocomplete, no syntax highlight, this "code" is not a part of automatic refactoring
  * Regular java code is a good alternative:
  ```
    public SvgAccountSheetDto toSvgDto(SvgAccount svgAccount) {
        var svgDto = toDto(svgAccount);
        svgDto.setExtraDate(svgShiftService.getCurrentSvgDate(svgAccount.getObservationDate()));
        svgDto.setSvgDateEditable(SvgMasterUtils.isCurrentUndervision(svgAccount.getPreviousDate()));
        return svgDto;
    }
    
    @Mapping(target = "extraDate", ignore = true)
    @Mapping(target = "svgDateEditable", ignore = true)
    abstract SvgAccountSheetDto toDto(SvgAccount svgAccount);
  ```
* Random mapping examples:
```
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, uses = { DateUtils.class })
public interface DocumentMapper {

    DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);

    /** Main method. Everything else is implementation details */
    DocumentV4 toV4(DocumentV5 document);

    /** Different enum names */
    @Mappings({@Mapping(source = "SIGNING", target = "SIGNED")})
    StatusV4 toV4(StatusV5 status);

    /** Different fields */
    @Mapping(source = "value", target = "description")
    @Mapping(target = "definedByCct", ignore = true)
    TagV4 toV4(TagV5 tag);

    /** Execute any java code! */
    @Mapping(target = "time", expression = "java( java.time.LocalDateTime.now() )")
    Notification xmlToDto(Notification xml);

    /** Map multiple objects to one */
    @AfterMapping
    default void multipleToOne(@MappingTarget Notification notification, MinDto dto, SourceType type) {
        notification.setMix(dto.getId(), type);
    }

    /** Reduce duplication */
    @Retention(RetentionPolicy.CLASS)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "location", ignore = true)
    @Mapping(target = "name", source = "basicName")
    @Mapping(target = "type", source = "newType")
    @interface CopyProperties { }

    @CopyProperties
    void copyProperties(@MappingTarget User user, WorkerDto dto)

    @CopyProperties
    void copyProperties(@MappingTarget User user, AdminDto dto)
    
    /** List to single entity */
    default SignatureV4 toV4(java.util.List<SignatureV5> values) {
        if (CollectionUtils.isEmpty(values)) {
            return null;
        }
        return toV4(values.get(0));
    }

    Signature toV4(SignatureV5 value);
}
```