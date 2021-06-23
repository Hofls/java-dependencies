package hofls.com.github.hiber.storage.locks_demo.pessimistic_lock;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Data
public class NotificationPess {

    @Id
    @GeneratedValue
    private long id;

    private String status;

}
