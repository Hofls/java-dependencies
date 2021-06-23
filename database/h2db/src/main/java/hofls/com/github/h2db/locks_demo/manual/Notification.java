package hofls.com.github.h2db.locks_demo.manual;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Data
public class Notification {

    @Id
    @GeneratedValue
    private long id;

    private String status;

}
