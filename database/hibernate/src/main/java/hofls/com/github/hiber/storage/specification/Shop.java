package hofls.com.github.hiber.storage.specification;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Shop {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shop")
    private List<Employee> employees;

}
