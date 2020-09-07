package hofls.com.github.javahibernateexample.storage.jpa_repository;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToOne
    private Campus campus;
}
