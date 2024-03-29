package hofls.com.github.h2db.hello_world;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Campus {

    @Id
    @GeneratedValue
    private long id;

    private String name;

}
