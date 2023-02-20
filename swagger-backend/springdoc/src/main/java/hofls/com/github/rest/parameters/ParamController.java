package hofls.com.github.rest.parameters;

import hofls.com.github.rest.parameters.types.ParametersInBody;
import hofls.com.github.rest.parameters.types.ParametersInQuery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

// url - http://www.example.com:8080/books/57433/index.jsp?user=test&login=check
// path - /books/57433/index.jsp
// query - user=test&login=check
@RequestMapping("/parameters")
@Tag(name = "parameters-controller", description = "Parameters example (body/path/query)")
@RestController
public class ParamController {

    private @Autowired HttpServletRequest httpRequest;

    @Operation(summary = "Complex objects in body + query")
    @PostMapping("post-method-complex")
    public String postMethodComplex(@RequestBody ParametersInBody objectInBody,
                                    ParametersInQuery objectInQuery) {
        return "Hey";
    }

    @Operation(summary = "Simple objects in body + query")
    @PostMapping("post-method-simple")
    public String postMethodSimple(
            @RequestBody @Parameter(required = true) @Schema(example = "Larry dotter") String objectInBody,
            @Parameter(required = true, example = "888") Integer objectInQuery) {
        return "Hey";
    }

    @Operation(summary = "Simple object in path")
    @GetMapping(value="{id}")
    public Long get(
            @Parameter(required = true, example = "19962193")
            @PathVariable Long id) {
        return id;
    }

    @Operation(summary = "Simple object in header")
    @GetMapping
    public String headerExample(
            @SuppressWarnings("unused")
            @Parameter(required = true, example = "Larry Dotter")
            @RequestHeader String bookName) {
        return httpRequest.getHeader("bookName");
    }

}
