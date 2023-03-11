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

    // CascadeType.PERSIST - on shop creation, will also create employees
    // orphanRemoval = true (must have with CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "shop")
    private List<Employee> employees;

}
