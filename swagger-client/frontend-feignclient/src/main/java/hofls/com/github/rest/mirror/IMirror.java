package hofls.com.github.rest.mirror;

import hofls.com.github.exception.CustomException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/** In real project this interface would be imported via gradle/maven */
@Tag(name = "Mirror", description = "Reflects everything back")
@RequestMapping("/mirror")
public interface IMirror {

    // To use POJO as GET parameter (for @FeignClient):
    // void find(@SpringQueryMap @Valid FindFieldsRequest request)
    @Operation(summary = "Reflects value back")
    @GetMapping(value="/{value}")
    String reflect(@PathVariable String value);

    @Operation(summary = "Throws error")
    @GetMapping(value="/throw")
    void throwError();

    @Operation(summary = "Throws custom error")
    @GetMapping(value="/throw/custom")
    void throwCustomError() throws CustomException;

}
