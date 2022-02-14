package hofls.com.github.rest.validation.types;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class RegexObject {

    @Pattern(regexp = "[0-9]{7,12}")
    @Schema(example="123456")
    private String phoneNumber;
}
