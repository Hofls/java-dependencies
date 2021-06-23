package hofls.com.github.hiber.storage.specification;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Shop {

    @Id
    @GeneratedValue
    private long id;

    private String name;

}
