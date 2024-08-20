package hofls.com.github.rest.parameters.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutputObject {

    @Schema(description = "Width")
    private int width;

    @Schema(description = "Calculated area") // Add hidden = true if you don't need it in swagger
    @JsonProperty("area")
    public int getArea() {
        return width * 7;
    }
}
