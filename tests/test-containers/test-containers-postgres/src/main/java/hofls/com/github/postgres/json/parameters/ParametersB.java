package hofls.com.github.postgres.json.parameters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParametersB implements IParameters {
    private String description;
    private Integer room;
}
