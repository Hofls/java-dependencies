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