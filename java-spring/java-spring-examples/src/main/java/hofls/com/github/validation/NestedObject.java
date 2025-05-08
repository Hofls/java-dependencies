package hofls.com.github.validation;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class NestedObject {

    @NotEmpty
    private String fieldA;

    @Min(55)
    private Long fieldB;

}
