package hofls.com.github.rest.validation.types;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


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
