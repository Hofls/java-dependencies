### Converts document V5 to document V4
```
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
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