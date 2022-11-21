package hofls.com.github.rest.mirror;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** In real project this interface would be imported via gradle/maven */
@Tag(name = "Mirror", description = "Reflects everything back")
@RequestMapping("/mirror")
public interface IMirror {

    // @SpringQueryMap - allows to use POJO as GET parameter
    @Operation(summary = "Reflects value back")
    @GetMapping(value="/{value}")
    String reflect(@PathVariable String value);

}