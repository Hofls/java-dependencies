### JSONB - Pure SQL
* JSONB - Overview
```
    SELECT '{"content":{"date":"2023-01-02"}}'::jsonb @@ '$.content.date > "2023-01-01"';
    SELECT '{"content":{"value":43}}'::jsonb @@ '$.content.value < 44';
    
    SELECT '{"content":{"venous":17.2, "failed": true}}'::jsonb @@ '$.content.venous > 4 && $.content.failed == true';
    
    SELECT '{"content":{"venous":17.2, "status": "OK"}}'::jsonb @> '{"content": {"status": "OK"}}';
    SELECT '{"content":{"venous":17.2, "status": "OK"}}'::jsonb -> 'content'->>'status' = 'OK';
    
    SELECT '[{"action":"SIGNED", "status": "OK"}, {"action":"SAVED", "status": "DELETED"}]'::jsonb @> '[{"status": "OK"}]';
    
    -- 1 json element = 1 row in response
    SELECT jsonb_array_elements('[{"action":"SIGNED"},{"action":"SAVED"}]'::jsonb);
    
    SELECT * FROM 
        jsonb_array_elements('[{"action":"SIGNED", "status": "OK"}, {"action":"SAVED", "status": "DELETED"}]'::jsonb) AS computer
    WHERE computer->>'action' = 'SIGNED' AND computer->>'status' = 'OK'
```
* JSONB - Query & Index
```
    {
      "content": {
        "status": "ACTIVE"
        "weight": 84.3
      }
    }
    
    -- 1
    SELECT *
    FROM doc_card
    WHERE (doc->'content'->>'status') = 'INACTIVE';
    
    CREATE INDEX doc_status_idx
    ON doc_card ((doc->'content'->>'status'));
    
    -- 2 (Upper limit of cost can be scary, but execution time is still greatly improves)
    SELECT *
    FROM doc_card
    WHERE (CAST(doc->'content'->>'weight' AS numeric)) > 80;
    
    CREATE INDEX doc_weight_idx
    ON doc_card
    ((CAST(doc->'content'->>'weight' AS numeric)));
    
    -- 3
    SELECT *
    FROM doc_card
    WHERE doc @@ '$.content.weight > 44';
    
    SELECT *
    FROM patient.doc_card e
    WHERE doc @> '{"content": {"weight": 53.8}}'
    
    CREATE INDEX doc_idx ON doc_card
    USING gin (doc);
```
* JSONB - Query & Index
```
    [
       {
          "action":"SIGNED",
          "userId":"97fbd76a-bd5e-496b-a778-33b2dfa96e31",
          "dateTime":"2023-07-26T08:45:00",
          "userName":"John"
       },
       {
          "action":"SAVED",
          "userId":"97fbd76a-bd5e-496b-a778-33b2dfa96e31",
          "dateTime":"2023-07-26T08:44:34",
          "userName":"Helga"
       }
    ]
    
    -- 1
    SELECT *
    FROM doc_card
    WHERE changelog @> '[{"action": "SIGNED"}]';
    
    SELECT *
    FROM doc_card e
    WHERE changelog @@ '$.dateTime > "2024-07-26T08:44:00"';
    
    CREATE INDEX doc_changelog_idx ON doc_card
    USING gin (changelog);
```

### JSONB - Java
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
