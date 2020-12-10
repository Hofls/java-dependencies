package hofls.com.github.rest.validation;

import hofls.com.github.rest.common.exception.exceptions.BadRequestException;
import hofls.com.github.rest.common.exception.exceptions.InternalServerException;
import hofls.com.github.rest.api.example.types.Human;
import hofls.com.github.rest.validation.types.ObjectInBody;
import hofls.com.github.rest.validation.types.ObjectInPath;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/** Validation + Errors */
@Api(tags = {"errors-service"})
@RequestMapping("/errors")
@RestController
public class ErrorController {

    @ApiOperation(value = "Throws different errors, based on id", notes = "")
    @GetMapping(value="{id}")
    public Human throwError(@PathVariable String id) {
        if ("1".equals(id)) {
            throw new BadRequestException("Sample exception, it is clients fault (400 code)");
        } else if ("2".equals(id)) {
            throw new InternalServerException("Sample exception, it is servers fault (500 code)");
        } else {
            Human human = new Human();
            human.setName("Helga");
            human.setProfession("Archer");
            return human;
        }

    }

    @ApiOperation(value = "Validates object", notes = "")
    @PostMapping("validate")
    public Long validationExample(@Valid @RequestBody ObjectInBody objectInBody, @Valid ObjectInPath objectInPath) {
        return 777L;
    }


}
