package hofls.com.github.javagraphql.data.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    private String id;
    private String firstName;
    private String lastName;

}
