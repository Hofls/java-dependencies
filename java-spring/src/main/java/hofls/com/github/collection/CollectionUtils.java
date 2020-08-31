package hofls.com.github.collection;

import java.util.Collections;
import java.util.List;

public class CollectionUtils {

    /** To avoid NullPointerException in cycles */
    public static <T> List<T> safe(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }
}
