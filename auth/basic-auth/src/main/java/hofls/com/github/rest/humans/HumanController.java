package hofls.com.github.rest.humans;

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

    @ApiOperation(value = "Unauthenticated user is able to send GET request", notes = "")
    @GetMapping
    public Map<Long, String> getAll() {
        return people;
    }

    @ApiOperation(value = "Only user with MODERATOR/ADMIN role is able to send POST request", notes = "")
    @PostMapping
    public Long addHuman(@RequestBody String human) {
        people.put(++index, human);
        return index;
    }

    @ApiOperation(value = "Only user with ADMIN role is able to send DELETE request", notes = "")
    @DeleteMapping
    public void removeAll() {
        people.keySet().removeIf(value -> true);
    }

}
