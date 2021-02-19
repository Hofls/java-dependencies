package hofls.com.github.rest.parameters;

import hofls.com.github.rest.parameters.types.ParametersInBody;
import hofls.com.github.rest.parameters.types.ParametersInPath;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(tags = {"parameters-controller"})
@RequestMapping("/parameters")
@RestController
public class ParamController {

    private @Autowired HttpServletRequest httpRequest;

    @ApiOperation(value = "Post method example")
    @PostMapping("post-method")
    public String postMethod(@RequestBody ParametersInBody objectInBody,
                             ParametersInPath objectInPath) {
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
