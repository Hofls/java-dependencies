package hofls.com.github.javahibernateexample.locks_demo.manual;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class NotificationLock {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notification_id", referencedColumnName = "id", unique = true)
    private Notification notification;

}
