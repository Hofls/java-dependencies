package hofls.com.github.rest.people;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(tags = {"people-controller"})
@RequestMapping("/people")
@RestController
public class HumanController {

    public static Map<Long, String> people = new HashMap<>();
    private static long index = 1;

    @ApiOperation(value = "Only authenticated user is able to send GET request", notes = "")
    @GetMapping
    public Map<Long, String> getAll(@RequestHeader(value = "AUTH_API_KEY") String authApiKey) {
        return people;
    }

    @ApiOperation(value = "Only authenticated user is able to send POST request", notes = "")
    @PostMapping
    public Long addHuman(@RequestHeader(value = "AUTH_API_KEY") String authApiKey, @RequestBody String human) {
        people.put(++index, human);
        return index;
    }

}
