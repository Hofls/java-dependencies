package hofls.com.github.javahibernateexample.storage.university;


import hofls.com.github.javahibernateexample.storage.university.Campus;
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
