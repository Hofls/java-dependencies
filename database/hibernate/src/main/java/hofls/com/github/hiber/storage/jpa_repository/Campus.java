package hofls.com.github.hiber.storage.jpa_repository;


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
