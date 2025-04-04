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
* What's the point of `repository.save() and repository.flush()`?
  * flush() makes DB aware of changes (even if they are not commited yet)
  * e.g. new copy of row won't trigger unique constraints, because old row was changed and flushed
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
* Delete rows from a table:
```
  /** First selects all the rows for deletion, loads them in RAM, then for each row executes a separate DELETE request */
  void deleteByCreationDateTimeBefore(OffsetDateTime monthAgo); // Very bad
  
  @Modifying
  @Query(nativeQuery = true, value = """
      DELETE FROM frontend_logs
      WHERE creation_date_time < (NOW() - INTERVAL '1 month')
  """)
  void deleteOldErrors(); // Very good (no selects, no load on RAM, deletes everything with 1 request)
  
```