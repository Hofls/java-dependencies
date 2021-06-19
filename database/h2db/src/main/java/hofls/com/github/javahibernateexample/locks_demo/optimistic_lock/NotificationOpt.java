package hofls.com.github.javahibernateexample.locks_demo.optimistic_lock;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;


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
