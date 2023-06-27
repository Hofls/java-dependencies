# Hibernate (JPA implementation)

#### Run locally
* Maven - execute `mvn clean spring-boot:run`
* Gradle - execute `gradlew bootRun`
* Connect with h2db console:
    * Open [link](http://localhost:8080/h2-console) in the browser
    * Fill the fields:
        * `User Name` is empty
        * `Driver`: `org.h2.Driver`
        * `JDBC URL` -  `jdbc:h2:file:~/example-db`
    
#### Open h2 console while running tests (on breakpoint)
* Insert `H2Configuration.java` in project, make sure package is scanned (e.g. look at `StudentRepositoryTestV2`)
* Insert thread breakpoint (By default - breakpoint stops entire VM)
* Run tests in debug mode, on breakpoint open [link](http://localhost:8086/)
    * Fill the fields:
        * `User Name` is empty
        * `Driver`: `org.h2.Driver`
        * `JDBC URL`: `jdbc:h2:mem:test-db`

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
    * Add `@JsonManagedReference` on main reference (near `@ManyToOne`) 
    * Add `@JsonBackReference` on back reference (near `@OneToMany`)
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