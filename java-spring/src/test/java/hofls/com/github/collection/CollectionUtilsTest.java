package hofls.com.github.collection;

import org.junit.jupiter.api.Test;

import java.util.List;

import static hofls.com.github.collection.CollectionUtils.safe;

class CollectionUtilsTest {

    @Test
    void testSafe() {
        List<String> list = null;
        for (String elem : safe(list)) {
            System.out.println(elem);
        }
    }

}
