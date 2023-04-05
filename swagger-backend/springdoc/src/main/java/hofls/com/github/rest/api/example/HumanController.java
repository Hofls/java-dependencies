package hofls.com.github.rest.api.example;

import hofls.com.github.rest.api.example.types.Human;
import hofls.com.github.rest.api.example.types.HumanFilter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** CRUD API example */
@Tag(name = "human-controller", description = "REST architecture example")
@RequestMapping("/people")
@RestController
public class HumanController {

    public static Map<Long, Human> people = new HashMap<>();
    private static long index = 1;

    @Operation(summary = "Returns all the humans")
    @GetMapping
    public Map<Long, Human> getAll() {
        return people;
    }

    @Operation(summary = "Returns human by id")
    @GetMapping(value="{id}")
    public Human getHuman(@PathVariable Long id) {
        return people.get(id);
    }

    @Operation(summary = "Filters humans")
    @GetMapping(value="filter")
    public List<Human> filter(HumanFilter humanFilter) {
        return people.values().stream()
                .filter(human -> humanFilter.getNames().contains(human.getName()))
                .filter(human -> humanFilter.getProfessions().contains(human.getProfession()))
                .collect(Collectors.toList());
    }

    @Operation(summary = "Filters humans by names")
    @GetMapping(value="filter-by-names")
    public List<Human> filterByNames(@RequestParam List<String> names) {
        return people.values().stream()
                .filter(human -> names.contains(human.getName()))
                .collect(Collectors.toList());
    }

    @Operation(summary = "Adds human to the list")
    @PostMapping
    public Long addHuman(@RequestBody Human human) {
        people.put(++index, human);
        return index;
    }

    @Operation(summary = "Updates human in the list")
    @PutMapping(value="{id}")
    public void updateHuman(@PathVariable Long id, @RequestBody Human human) {
        people.remove(id);
        people.put(id, human);
    }

    // @PatchMapping - in different package

    @Operation(summary = "Removes human from the list")
    @DeleteMapping(value="{id}")
    public void removeHuman(@PathVariable Long id) {
        people.remove(id);
    }

    @Operation(summary = "Removes all humans from the list")
    @DeleteMapping
    public void removeAll() {
        people.keySet().removeIf(value -> true);
    }

}
