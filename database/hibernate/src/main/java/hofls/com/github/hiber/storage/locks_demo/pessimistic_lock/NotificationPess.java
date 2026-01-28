package hofls.com.github.hiber.storage.locks_demo.pessimistic_lock;


import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
@Data
public class NotificationPess {

    @Id
    @GeneratedValue
    private long id;

    private String status;

}
