package hofls.com.github.rest.parameters;

import hofls.com.github.rest.parameters.types.ParametersInBody;
import hofls.com.github.rest.parameters.types.ParametersInQuery;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

// url - http://www.example.com:8080/main/index.jsp?user=test&login=check
// path - /main/index.jsp
// query - user=test&login=check
@Api(tags = {"parameters-controller"})
@RequestMapping("/parameters")
@RestController
public class ParamController {

    private @Autowired HttpServletRequest httpRequest;

    @ApiOperation(value = "Complex objects in body + query")
    @PostMapping("post-method-complex")
    public String postMethodComplex(@RequestBody ParametersInBody objectInBody,
                             ParametersInQuery objectInQuery) {
        return "Hey";
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "objectInBody", value = "Description A", required = true,
                    dataType = "String", paramType = "body", example = "let's go!"),
            @ApiImplicitParam(name = "objectInPath", value = "Description B", required = true,
                    dataType = "Integer", paramType = "query", example = "777")
    })
    @ApiOperation(value = "Simple objects in body + query")
    @PostMapping("post-method-simple")
    public String postMethodSimple(@RequestBody String objectInBody,
                             Integer objectInQuery) {
        return "Hey";
    }

    @ApiOperation(value = "Get method example")
    @GetMapping(value="{id}")
    public Long get(
            @ApiParam(required = true, example = "19962193")
            @PathVariable Long id) {
        return id;
    }

    @ApiOperation(value = "Request header example", notes = "")
    @GetMapping
    public String headerExample(
            @SuppressWarnings("unused")
            @ApiParam(required = true, example = "Larry Dotter")
            @RequestHeader String bookName) {
        return httpRequest.getHeader("bookName");
    }

}
