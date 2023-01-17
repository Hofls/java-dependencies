package hofls.com.github.postgres.json.parameters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParametersA implements IParameters {
    private String ip;
    private String port;
}
