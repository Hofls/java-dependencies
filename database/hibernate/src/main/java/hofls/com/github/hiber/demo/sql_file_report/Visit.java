package hofls.com.github.hiber.demo.sql_file_report;


import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
