package hofls.com.github.rest.mirror;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Mirror", description = "Reflects everything back")
@RequestMapping("/mirror")
public interface IMirror {

    @Operation(summary = "Reflects value back")
    @GetMapping(value="/{value}")
    String reflect(@PathVariable String value);

    @Operation(summary = "Throws error")
    @GetMapping(value="/throw")
    void throwError();

}
