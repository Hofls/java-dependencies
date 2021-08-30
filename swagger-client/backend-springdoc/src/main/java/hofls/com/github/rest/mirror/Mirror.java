package hofls.com.github.rest.mirror;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "kek", description = "Reflects everything back")
@RequestMapping("/mirror")
@RestController
public class Mirror {

    @Operation(summary = "Reflects value back")
    @GetMapping(value="{value}")
    public String reflect(@PathVariable String value) {
        return value + " (reflected)";
    }

}
