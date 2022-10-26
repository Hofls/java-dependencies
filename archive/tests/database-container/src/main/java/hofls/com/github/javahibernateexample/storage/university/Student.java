package hofls.com.github.javahibernateexample.storage.university;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
