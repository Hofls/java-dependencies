package hofls.com.github.json;

import lombok.Data;

import java.util.List;

@Data
public class Phone {

    private String number;
    private Integer id;
    private List<String> contacts;

}
