package hofls.com.github.rest;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/people")
@RestController
public class HumanController {

    public static Map<Long, String> people = new HashMap<>();
    private static long index = 1;

    @GetMapping
    public Map<Long, String> getAll() {
        return people;
    }

    @GetMapping(value="empty")
    public List<String> getEmpty() {
        return null;
    }

    @PostMapping
    public Long addHuman(@RequestBody String person) {
        people.put(++index, person);
        return index;
    }

}
