package hofls.com.github.rest.api.example;

import hofls.com.github.rest.api.example.types.Human;
import hofls.com.github.rest.api.example.types.HumanFilter;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** CRUD API example */
@Tag(name = "human-controller", description = "List of people (rest architecture example)")
@RequestMapping("/people")
@RestController
public class HumanController {

    public static Map<Long, Human> people = new HashMap<>();
    private static long index = 1;

    @ApiOperation(value = "Returns all the people", notes = "")
    @GetMapping
    public Map<Long, Human> getAll() {
        return people;
    }

    @ApiOperation(value = "Returns human by id", notes = "")
    @GetMapping(value="{id}")
    public Human getHuman(@PathVariable Long id) {
        return people.get(id);
    }

    @ApiOperation(value = "Filters humans", notes = "")
    @GetMapping(value="filter")
    public List<Human> filter(HumanFilter humanFilter) {
        return people.values().stream()
                .filter(human -> humanFilter.getNames().contains(human.getName()))
                .filter(human -> humanFilter.getProfessions().contains(human.getProfession()))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Filters humans by names", notes = "")
    @GetMapping(value="filter-by-names")
    public List<Human> filterByNames(@RequestParam List<String> names) {
        return people.values().stream()
                .filter(human -> names.contains(human.getName()))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Adds humans to the list", notes = "")
    @PostMapping
    public Long addHuman(@RequestBody Human human) {
        people.put(++index, human);
        return index;
    }

    @ApiOperation(value = "Updates humans in the list", notes = "")
    @PutMapping(value="{id}")
    public void updateHuman(@PathVariable Long id, @RequestBody Human human) {
        people.remove(id);
        people.put(id, human);
    }

    @ApiOperation(value = "Removes humans from the list", notes = "")
    @DeleteMapping(value="{id}")
    public void removeHuman(@PathVariable Long id) {
        people.remove(id);
    }

    @ApiOperation(value = "Removes all the people from the list", notes = "")
    @DeleteMapping
    public void removeAll() {
        people.keySet().removeIf(value -> true);
    }

}
