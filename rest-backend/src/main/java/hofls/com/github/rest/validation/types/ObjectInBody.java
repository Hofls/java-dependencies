package hofls.com.github.rest.validation.types;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ObjectInBody {

    @Valid
    @ApiModelProperty(value = "Inner class")
    private InnerClass innerClass;

    @Data
    public static class InnerClass {

        @NotEmpty
        @ApiModelProperty(example = "")
        private String fieldA;

        @Min(55)
        @NotNull
        @ApiModelProperty(example = "32")
        private Long fieldB;

        @AssertTrue(message = "Values should be bigger!")
        @ApiModelProperty(hidden = true)
        public boolean isValuesBigEnough() {
            // method name is crucial! if it doesnt start with "is" - nothing happens
            boolean isFieldABigEnough = fieldA != null && fieldA.length() > 8;
            boolean isFieldBbigEnough = fieldB > 100000;
            return isFieldABigEnough && isFieldBbigEnough;
        }

    }

}
