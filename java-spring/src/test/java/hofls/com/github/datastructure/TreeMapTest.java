package hofls.com.github.datastructure;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Other useful data structures:
 * HashMap - O(1) insert/get/delete
 * ArrayList
 * HashSet
 * Stack
 * Queue
 * LinkedList
 */
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

        Set<Integer> keysA = map.navigableKeySet().subSet(22, 44); // elements >= 22 && < 44
        assertEquals(new HashSet<>(Arrays.asList(23, 33, 43)), keysA);

        Set<Integer> keysB = map.navigableKeySet().headSet(30); // all elements < 30
        assertEquals(new HashSet<>(Arrays.asList(10, 23)), keysB);

        Set<Integer> keysC = map.navigableKeySet().tailSet(30); // all elements >= 30
        assertEquals(new HashSet<>(Arrays.asList(33, 43)), keysC);
    }
}
