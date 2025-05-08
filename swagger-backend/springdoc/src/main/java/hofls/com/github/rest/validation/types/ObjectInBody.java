package hofls.com.github.rest.validation.types;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ObjectInBody {

    @Valid
    @Schema(description = "Inner class")
    private InnerClass innerClass;

    @Data
    public static class InnerClass {

        @NotEmpty
        @Schema(description = "")
        private String fieldA;

        @Min(55)
        @NotNull
        @Schema(example = "32")
        private Long fieldB;

        @AssertFalse(message = "Values should be good'")
        @Schema(hidden = true)
        public boolean isValuesEvil() {
            // method name is crucial! if it doesn't start with "is" - nothing happens
            return "evil".equals(fieldA) || fieldB.equals(666L);
        }

    }

}
