package hofls.com.github.xml;

import lombok.Data;

import java.util.List;

@Data
public class Smartphone {

    private String number;
    private Integer id;
    private List<String> contacts;

}
