package hofls.com.github.rest.json;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/json")
@Tag(name = "json-controller", description = "Json example (takes any structure as input)")
@RestController
public class JsonController {

    private @Autowired HttpServletRequest httpRequest;

    @PostMapping("pretty-print")
    @Operation(summary = "Takes any json and pretty prints it")
    public String prettyPrint(@RequestBody @Schema(example = "{\"name\":\"John\",\"age\":30}") JsonNode jsonNode) {
        return jsonNode.toPrettyString();
    }

}
