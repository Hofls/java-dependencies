package hofls.com.github.utils;

import lombok.SneakyThrows;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class ObjectUtils {

    @SneakyThrows
    public static <T> T emptyToNullRecursive(T obj) {
        if (obj == null) return null;

        Class<?> clazz = obj.getClass();
        boolean allFieldsEmpty = true;

        for (var field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            int mods = field.getModifiers();
            if (Modifier.isStatic(mods)) continue;

            Object value = field.get(obj);
            if (value == null) continue;

            String pkg = value.getClass().getPackageName();

            if (pkg.startsWith("java.")) {
                boolean empty = false;

                if (value instanceof CharSequence cs) {
                    empty = cs.isEmpty();
                } else if (value instanceof Collection<?> col) {
                    empty = col.isEmpty();
                } else if (value instanceof Map<?, ?> map) {
                    empty = map.isEmpty();
                } else if (value.getClass().isArray()) {
                    empty = Array.getLength(value) == 0;
                }

                if (!empty) {
                    allFieldsEmpty = false;
                } else {
                    field.set(obj, null);
                }
            } else {
                Object cleaned = emptyToNullRecursive(value);
                field.set(obj, cleaned);
                if (cleaned != null) {
                    allFieldsEmpty = false;
                }
            }
        }

        return allFieldsEmpty ? null : obj;
    }

    @SneakyThrows
    public static <T> T emptyToNull(T obj) {
        if (obj == null) {
            return null;
        }

        for (var field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            var value = field.get(obj);
            var notEmpty = (value instanceof List<?> && !CollectionUtils.isEmpty((List<?>) value));
            var notNull = value != null;
            if (notNull && notEmpty) {
                return obj;
            }
        }

        return null;
    }


    public static <T> List<T> emptyToNull(List<T> list) {
        return CollectionUtils.isEmpty(list) ? null : list;
    }

}
