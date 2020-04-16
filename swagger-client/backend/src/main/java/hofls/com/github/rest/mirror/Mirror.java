package hofls.com.github.rest.mirror;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"mirror-service"})
@RequestMapping("/mirror")
@RestController
public class Mirror {

    @ApiOperation(value = "Reflects value back", notes = "")
    @GetMapping(value="{id}")
    public String reflect(@PathVariable(value = "id") String value) {
        return value + " (reflected)";
    }

}
