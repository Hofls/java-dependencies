package hofls.com.github.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Phone {

    private String number;
    private Integer id;
    private List<String> contacts;

}
