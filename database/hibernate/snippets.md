* If appears error `Infinite recursion (StackOverflowError)` during serialization/deserialization:
    * Add `@JsonManagedReference` on main reference (near `@ManyToOne`) 
    * Add `@JsonBackReference` on back reference (near `@OneToMany`)
