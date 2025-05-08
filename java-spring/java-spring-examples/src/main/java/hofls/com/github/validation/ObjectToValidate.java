package hofls.com.github.validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class ObjectToValidate {

    @NotEmpty
    private String fieldA;

    @Min(55)
    private Long fieldB;

    @Valid
    private NestedObject nested;

}
