package hofls.com.github.javahibernateexample.storage.specification;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToOne
    private Shop shop;
}
