#### Snippets
* Get info about last invoice:
    ```
    private Predicate lastInvoice(Root<Invoice> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        var subquery = query.subquery(Long.class);
        var subRoot = subquery.from(Invoice.class);
        subquery.select(criteriaBuilder.max(subRoot.get(Invoice_.NUMBER)));
        subquery.where(criteriaBuilder.equal(subRoot.get(Invoice_.FOR_PERIOD), true));
        subquery.groupBy(subRoot.get(Invoice_.TYPE));
        return root.get(Invoice_.NUMBER).in(subquery);
    }
    ```
* Join and condition within specification:
    * `predicates.add(criteriaBuilder.equal(root.get(AstCard_.USER).get(User_.ORGANIZATION_ID), request.getOrganizationId()));`
    * Joins from ast_card table to patient table, create condition for user.organization_id
* If appears error `Infinite recursion (StackOverflowError)` during serialization/deserialization:
    * Alternative №1:
      * Add `@JsonManagedReference` on main reference (near `@OneToMany`) 
      * Add `@JsonBackReference` on back reference (near `@ManyToOne`)
    * Alternative №2:
      * `@ToString(exclude = {"field_that_causes_troubles"})`
* Sort by different fields:
    ```
    List<Sort.Order> orders = new ArrayList<>();
    orders.add(new Sort.Order(Sort.Direction.DESC, "date"));
    orders.add(new Sort.Order(Sort.Direction.ASC, "department.name"));
    orders.add(new Sort.Order(Sort.Direction.ASC, "user.name"));
    return PageRequest.of(0, 10, Sort.by(orders));
    ```
* Composite id - `@IdClass`
* Map multiple classes on one table - `@Embedded` and `@Embeddable`
* Lazy field (often doesn't work, better use LAZY with @OneToOne / @ManyToOne):
    ```
    @Basic(fetch = FetchType.LAZY)
    private String content;
    ```
* Update only changed fields:
    * Useful when different transactions trying to update different entity fields at the same time
    ```
    @DynamicUpdate
    @Table
    ```
* Custom countQuery:
    ```
    String sqlHead = """SELECT user_id, user_name """;
    String sqlBody = """FROM user """;
    @Query( nativeQuery = true,
            countQuery = "SELECT COUNT(*) " + sqlBody,
            value = sqlHead + sqlBody + "ORDER BY registration_date DESC"
    )
    Page<IUser> findUsers()
    ```
* Alternative to DB triggers:
    ```
    @PreUpdate
    @PrePersist
    public void calculateFields() {
        this.fullName = this.firstName + this.middleName + this.lastName;
    }
    ```
* If sometimes you only need ID, but other times you need entire entity (best of both worlds):
```
    @Column(name = "customer_id")
    private UUID customerId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;
```
* Join table (shop_type.shop_id, shop_type.shop_type_id) without extra entity class :
```
    class Shop {
        @ManyToMany
        @JoinTable(name = "shop_type",
                joinColumns = @JoinColumn(name = "shop_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "shop_type_id", referencedColumnName = "id"))
        private List<ShopType> shopTypes;
    }
```
* Completely replace list in DB (add new entities, update old one, delete those no longer in the list):
```
    private void replaceMarks(List<SaveSvgMark> requestMarks, SvgBucket bucket) {
        var marksToSave = new ArrayList<SvgMark>();
        for (var requestMark : safe(requestMarks)) {
            if (requestMark.getId() == null) {
                var newMark = new SvgMark(requestMark);
                marksToSave.add(newMark);
            } else {
                var oldMark = bucket.getMarkById(requestMark.getId());
                oldMark.setValues(requestMark);
                marksToSave.add(oldMark);
            }
        }
        var idsForRemoval = bucket.getMarks().stream()
                .map(SvgMark::getId)
                .filter(uuid -> marksToSave.stream().noneMatch(value -> value.getId() != null && value.getId().equals(uuid)))
                .toList();
        bucket.setMarks(marksToSave);
        svgMarkRepository.deleteAllById(idsForRemoval);
    }
```
* One to one relationship example (user has one address)
```
  class User {
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
  }
  
  // Optional. Needed only for convenient access to user from address:
  class Address {
    @JsonBackReference
    @OneToOne(mappedBy = "address")
    private User user;
  }
  
  // Optional. Specification demo (find users from "Drooski st.")
  predicates.add(criteriaBuilder.equal(root.join("address").get("street"), "Drooski st."));
```
* Generic table "Warehouse", where column "ability_id" can have ids from a bunch of different tables:
```
  public class Warehouse {
    @Column
    private UUID abilityId;
    
    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "abilityId", nullable = false, insertable = false, updatable = false)
    private UndeadAbility undeadAbility;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "abilityId", nullable = false, insertable = false, updatable = false)
    private HumanAbility humanAbility;
    
    // Optional. Very rare case, when you can't set abilityId, you have to set an entire entity (because it has no id yet):
    @PreUpdate
    @PrePersist
    private void updateAbilityId() {
        if (undeadAbility != null) {
            this.abilityId = undeadAbility.getId();
        } else if (undeadAbility != null) {
            this.abilityId = humanAbility.getId();
        }
    }
  }
```
* Error "Value too long for type character varying(255)" (usually happens in tests, when all tables are automatically created)
```
    @Column(nullable = false, columnDefinition = "TEXT") // TEXT type is bigger than 255 characters
    private String name;
```
* Find users that have both ACTIVE and WAITING statuses (jsonb) 
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
* Search by jsonb:
```
    -- Warning! Couldn't find a way to create fast index for jsonb_array_elements 
    @Query(nativeQuery = true, value = """
        SELECT special.*
        FROM special_card special,
             jsonb_array_elements(computer_params->'computer') AS computer
        WHERE computer->>'computerId' = :computerId
          AND computer->>'startAt' < :endDate
          AND (computer->>'endAt' IS NULL OR computer->>'endAt' > :startDate)
    """)
    List<SpecialCard> findBycomputer(@Param("computerId") String computerId,
                                  @Param("startDate") LocalDateTime startDate,
                                  @Param("endDate") LocalDateTime endDate);

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
* JSONB - Random
```
    SELECT '{"content":{"venous":17.2}}'::jsonb @@ '$.content.venous > 4';
    
    SELECT '{"content":{"date":"2023-01-02"}}'::jsonb @@ '$.content.date > "2023-01-01"';
    
    SELECT '{"content":{"venous":17.2, "status": "OK"}}'::jsonb @> '{"content": {"status": "OK"}}';
    
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
