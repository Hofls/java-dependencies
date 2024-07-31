
* Alternative to @JsonFormat annotation (configure default format for all dates):
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