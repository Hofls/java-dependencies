package hofls.com.github.rest.validation.types;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NotNull;

@Data
public class ObjectInPath {
    @NotNull
    @Negative
    @Schema(example="17")
    private Long fieldA;

    @Max(55)
    @NotNull
    @Schema(example="100")
    private Integer fieldB;

    @Schema(required = true) // only works for swagger-ui (try to send request via curl)
    private String notReallyRequired;
}
