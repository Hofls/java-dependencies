package hofls.com.github.hiber.storage.locks_demo.manual;


import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
@Data
public class Notification {

    @Id
    @GeneratedValue
    private long id;

    private String status;

}
