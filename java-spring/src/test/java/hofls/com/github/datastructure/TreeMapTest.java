package hofls.com.github.datastructure;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeMapTest {

    /**
     * Red black tree (self-balancing binary search tree)
     * Everything is O(log n)
     */
    @Test
    public void checkTreeMap() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(10, "A");
        map.put(23, "B");
        map.put(33, "C");
        map.put(43, "D");

        Set<Integer> keysA = map.navigableKeySet().subSet(23, 43); // elements >= 23 && < 33
        assertEquals(keysA, new HashSet<>(Arrays.asList(23, 33)));

        Set<Integer> keysB = map.navigableKeySet().headSet(33); // all elements < 33
        assertEquals(keysB, new HashSet<>(Arrays.asList(10, 23)));

        Set<Integer> keysC = map.navigableKeySet().tailSet(33); // all elements >= 33
        assertEquals(keysC, new HashSet<>(Arrays.asList(33, 43)));
    }
}
