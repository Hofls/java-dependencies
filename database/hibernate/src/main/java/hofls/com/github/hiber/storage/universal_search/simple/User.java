package hofls.com.github.hiber.storage.universal_search.simple;


import hofls.com.github.hiber.storage.specification.Shop;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String status;

    private LocalDate registrationDate;

    private Long points;

}
