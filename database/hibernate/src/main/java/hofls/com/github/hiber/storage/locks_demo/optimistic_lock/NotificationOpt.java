package hofls.com.github.hiber.storage.locks_demo.optimistic_lock;


import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;


@Entity
@Data
public class NotificationOpt {

    @Id
    @GeneratedValue
    private long id;

    private String status;

    @Version // yep, that's all you need for optimistic locking!
    private long version;


}
