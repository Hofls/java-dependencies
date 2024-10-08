package hofls.com.github.liqui.storage.university;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Student {

    @Id
    @GeneratedValue
    private long id;

    private String firstName;

}
