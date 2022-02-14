package hofls.com.github.rest.same.name;


import hofls.com.github.rest.same.name.types.ResponseA;
import hofls.com.github.rest.same.name.types.ResponseB;
import hofls.com.github.rest.same.name.types.ResponseC;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "responses-controller", description = "Model bug example")
@RequestMapping("/models")
@RestController
public class ModelController {

    @Operation(summary = "Look at weird response model")
    @GetMapping(value="responseA")
    public ResponseA getResponseA() {
        return null;
    }

    @Operation(summary = "Look at weird response model")
    @GetMapping(value="responseB")
    public ResponseB getResponseB() {
        return null;
    }

    @Operation(summary = "Look at good response model")
    @GetMapping(value="responseC")
    public ResponseC getResponseC() {
        return null;
    }

}
