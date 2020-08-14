package hofls.com.github.rest.parameters;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = {"parameters-controller"})
@RequestMapping("/parameters")
@RestController
public class ParamController {

    @ApiOperation(value = "Post method example", notes = "")
    @PostMapping("post-method")
    public String postMethod(@Valid @RequestBody ParametersInBody objectInBody, @Valid ParametersInPath objectInPath) {
        return "Hey";
    }

}
