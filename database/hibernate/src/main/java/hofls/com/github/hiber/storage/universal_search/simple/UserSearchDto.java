package hofls.com.github.hiber.storage.universal_search.simple;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Data
public class UserSearchDto {

    private String name;

    private List<String> statuses;

    private LocalDate registeredAfter;

    private Boolean hasPoints;

}
