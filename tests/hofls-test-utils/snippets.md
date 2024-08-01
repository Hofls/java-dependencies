
* Alternative №1 to @JsonFormat annotation (configure default format for all dates) \
Works with spring-web (swagger) and with hibernate (jsonb) \
Source - https://stackoverflow.com/questions/67147652/jsonb-ignores-jackson-serialization-inclusion \
Create hibernate.properties in resources folder with text "hibernate.types.jackson.object.mapper=hofls.com.github.config.JacksonConfig" \
For new hibernate versions consider using JSON_FORMAT_MAPPER - https://stackoverflow.com/questions/66656772/use-jackson-objectmapper-configured-by-spring-boot-in-hibernate
```
@Configuration // @Configuration and @Bean are needed for spring-web (Swagger); hibernate (jsonb) works without them
public class JacksonConfig implements ObjectMapperSupplier {

    @Override
    @Bean
    public ObjectMapper get() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

}
```

* Alternative №2 to @JsonFormat annotation (configure default format for all dates): \
Works with spring-web (swagger)
```
@Configuration
public class DateTimeConfig {
    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    private void addSerializers() {
        SimpleModule module = new SimpleModule();

        // module.addSerializer(OffsetDateTime.class, new OffsetDateTimeCustomSerializer());
        // module.addDeserializer(OffsetDateTime.class, new OffsetDateTimeCustomDeserializer());

        module.addSerializer(LocalDateTime.class, new LocalDateTimeCustomSerializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeCustomDeserializer());

        objectMapper.registerModule(module);
    }

    public static class LocalDateTimeCustomSerializer extends JsonSerializer<LocalDateTime> {
        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        @Override
        public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.format(FORMATTER));
        }
    }

    public static class LocalDateTimeCustomDeserializer extends JsonDeserializer<LocalDateTime> {
        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss[.SSS]");

        @Override
        public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            String dateTimeString = p.getText();
            return LocalDateTime.parse(dateTimeString, FORMATTER);
        }
    }
}
```

* Mock date:
```
    @Test
    void redisTest() throws Exception {
        try (var mock = DateTimeTestUtils.mockLocalDateTime("2022-08-10T12:10")) {
            service.send();
            var actual = service.read();
            var expected = "Test message. Creation time - 2022-08-10T12:10";
            assertEquals(expected, actual);
        }
    }
    
    public class DateTimeTestUtils {
    
        public static MockedStatic<LocalDateTime> mockLocalDateTime(String dateTimeStr) {
            LocalDateTime testDateTime = LocalDateTime.parse(dateTimeStr);
            return mockLocalDateTime(testDateTime);
        }
    
        public static MockedStatic<LocalDateTime> mockLocalDateTime(LocalDateTime testDateTime) {
            MockedStatic<LocalDateTime> mock = Mockito.mockStatic(LocalDateTime.class, Mockito.CALLS_REAL_METHODS);
            mock.when(LocalDateTime::now).thenReturn(testDateTime);
            return mock;
        }
    
        public static OffsetDateTime createOffsetDateTimeCurrentTimezone(String dateTime) {
            var timezone = DateTimeUtils.now().getOffset().toString();
            return OffsetDateTime.parse(dateTime + timezone);
        }
    }
```