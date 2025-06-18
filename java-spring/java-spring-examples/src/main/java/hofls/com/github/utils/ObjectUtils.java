package hofls.com.github.utils;

import lombok.SneakyThrows;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class ObjectUtils {

    @SneakyThrows
    public static <T> T emptyToNull(T obj) {
        if (obj == null) {
            return null;
        }

        for (var field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            var value = field.get(obj);
            if (value != null) {
                return obj;
            }
        }

        return null;
    }

    public static <T> List<T> emptyToNull(List<T> list) {
        return CollectionUtils.isEmpty(list) ? null : list;
    }

}
