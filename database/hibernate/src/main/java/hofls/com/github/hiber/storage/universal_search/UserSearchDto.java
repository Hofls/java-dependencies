package hofls.com.github.hiber.storage.universal_search;


import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * Request from frontend
 */
@Data
public class UserSearchDto {

    private String name;

    private List<String> statuses;

    private LocalDate registeredAfter;

    private Boolean hasPoints;

}
