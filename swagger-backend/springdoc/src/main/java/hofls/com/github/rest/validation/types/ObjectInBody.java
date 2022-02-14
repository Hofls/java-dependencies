package hofls.com.github.rest.validation.types;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
        @Schema(description = "32")
        private Long fieldB;

        @AssertTrue(message = "Values should be bigger!")
        @Schema(hidden = true)
        public boolean isValuesBigEnough() {
            // method name is crucial! if it doesn't start with "is" - nothing happens
            boolean isFieldABigEnough = fieldA != null && fieldA.length() > 8;
            boolean isFieldBbigEnough = fieldB > 100000;
            return isFieldABigEnough && isFieldBbigEnough;
        }

    }

}
