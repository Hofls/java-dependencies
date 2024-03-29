package hofls.com.github.validation;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class ObjectToValidate {

    @NotEmpty
    private String fieldA;

    @Min(55)
    private Long fieldB;

    @Valid
    private NestedObject nested;

}
