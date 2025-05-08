package hofls.com.github.rest.validation;

import hofls.com.github.rest.common.exception.exceptions.BadRequestException;
import hofls.com.github.rest.common.exception.exceptions.InternalServerException;
import hofls.com.github.rest.validation.types.ObjectInBody;
import hofls.com.github.rest.validation.types.ObjectInPath;
import hofls.com.github.rest.validation.types.RegexObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


/**
 * Validation + Errors
 * Spring Boot 2.3.0 excluded dependency "spring-boot-starter-validation", so you have to add it manually
 */
@RequestMapping("/errors")
@Tag(name = "error-controller", description = "Different http errors")
@RestController
public class ErrorController {

    @Operation(summary = "Throws different errors, based on id")
    @GetMapping(value="{id}")
    public String throwError(@PathVariable String id) {
        if ("1".equals(id)) {
            throw new BadRequestException("Sample exception, it is clients fault (400 code)");
        } else if ("2".equals(id)) {
            throw new InternalServerException("Sample exception, it is servers fault (500 code)");
        } else {
            return "OK";
        }

    }

    @Operation(summary = "Body validation")
    @PostMapping("body")
    public Long bodyValidation(@Valid @RequestBody ObjectInBody objectInBody) {
        return 777L;
    }

    @Operation(summary = "Path validation")
    @PostMapping("path")
    public Long pathValidation(@Valid ObjectInPath objectInPath) {
        return 777L;
    }

    @Operation(summary = "Regex validation")
    @PostMapping("regex")
    public Long regexValidation(@Valid @RequestBody RegexObject objectInBody, @Valid RegexObject objectInPath) {
        return 777L;
    }

}
