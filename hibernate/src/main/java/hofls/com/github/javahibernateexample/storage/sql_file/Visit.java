package hofls.com.github.javahibernateexample.storage.sql_file;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Visit {

    @Id
    @GeneratedValue
    private long id;

    private Long branchId;

    private LocalDate accidentDate;

    private LocalDate birthDate;

}
