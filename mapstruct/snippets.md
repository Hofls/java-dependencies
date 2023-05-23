### Converts document V5 to document V4
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
    default SignatureV4 toV4(
            java.util.List<SignatureV5> value) {
        if (CollectionUtils.isEmpty(value)) {
            return null;
        }
        return toV4(value.get(0));
    }

    Signature toV4(SignatureV5 value);
}
```