package hofls.com.github.liqui.storage.university;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue
    private long id;

    private String firstName;

}
