package hofls.com.github.annotation;

import java.lang.reflect.Field;

// Can be combined with aspects (@Before), to automatically scan parameters
public final class AnnotationProcessor {

    private AnnotationProcessor() {}

    public static void throwIfPossessed(Object object) throws IllegalAccessException {
        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(NotEvil.class)) {
                final NotEvil annotation = field.getAnnotation(NotEvil.class);
                String fieldComment = annotation.comment();
                field.setAccessible(true);
                Object value =  field.get(object);
                if (value.toString().equals("666")) {
                    throw new RuntimeException("Field is possessed by evil! PS " + fieldComment);
                }
            }
        }
    }

}