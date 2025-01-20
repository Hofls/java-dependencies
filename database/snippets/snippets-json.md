### JSONB - Java
* For pure JSONB - look at `database -> relational -> postgresql -> json.md` in `useful-info` repository
* Avoid `com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException: Unrecognized field`
```
    // Problem - you dropped deperecated field from jsonb UserAddressDto, but now DB throws errors
    // Solution - ignore unknown fields
    
    @Data
    @Entity
    @DynamicUpdate
    public class UserEntity {
        @Type(type = "jsonb")
        @Column(columnDefinition = "jsonb")
        private UserAddressDto address;
        
        @Type(type = "jsonb")
        @Column(columnDefinition = "jsonb")
        private UserReportDto report;
    }
    
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true) 
    public class UserAddressDto {}
```
* Find users that have both ACTIVE and WAITING statuses (JSONB)
```
    @TypeDefs({@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)})
    public class User {
        @Type(type = "jsonb")
        @Column(columnDefinition = "jsonb")
        private List<Status> statuses; // Example - '["POSTPONED", "ACTIVE", "WAITING]'
    }
    
    public class JsonUtils {
        @SneakyThrows
        public static <E extends Enum<E>> String enumToJson(E enumElement) {
            return enumToJson(List.of(enumElement));
        }
        @SneakyThrows
        public static <E extends Enum<E>> String enumToJson(List<E> enumElements) {
            var mapper = new ObjectMapper();
            return mapper.writeValueAsString(enumList);
        }
    }
    public class UserRepository {
        @Query(nativeQuery = true, value = "SELECT * FROM user WHERE statuses @> CAST(:statuses AS jsonb)")
        List<User> findBy(@Param("statuses") String statuses);
        
        default List<User> findBy(List<Status> statuses) {
            findBy(JsonUtils.enumToJson(statuses);
        }
    }
    public class UserService {
        var users = userRepository.findBy(List.of(ACTIVE, WAITING));
    }
```
* Search by JSONB:
```
    -- Warning! Couldn't find a way to create fast index for jsonb_array_elements
    @Query(nativeQuery = true, value = """
        SELECT special.*
        FROM special_card special,
             jsonb_array_elements(computer_params->'computer') AS computer
        WHERE 
          -- Next line is necessary for optimization (via index), generates json {"computer": ["computerId": "23"]}
          computer_params @> jsonb_build_object('computer', jsonb_build_array(jsonb_build_object('computerId', :computerId)))
          AND computer->>'computerId' = :computerId
          -- Without CAST, PostgreSQL will compare VARCHAR and TIMESTAMP (works for dates, but breaks for time):
          AND (CAST(computer->>'startAt' AS TIMESTAMP)) < :endDate 
          AND (computer->>'endAt' IS NULL OR (CAST(computer->>'endAt' AS TIMESTAMP)) > :startDate)
    """)
    List<SpecialCard> findBycomputer(@Param("computerId") String computerId,
                                  @Param("startDate") LocalDateTime startDate,
                                  @Param("endDate") LocalDateTime endDate);

    Index:
    CREATE INDEX special_params_idx ON special_card
			USING gin (computer_params);

    Json example:
    {
    "id": 1,
    "name": "Special Card 1",
    "computer_params": {
      "computer": [
        {
          "computerId": "comp123",
          "startAt": "2023-01-01T10:00:00",
          "endAt": "2023-01-10T10:00:00"
        },
        {
          "computerId": "comp456",
          "startAt": "2023-01-05T10:00:00",
          "endAt": null
        }
      ]
    }
```
