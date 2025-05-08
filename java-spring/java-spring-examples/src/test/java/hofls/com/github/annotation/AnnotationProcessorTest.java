package hofls.com.github.annotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AnnotationProcessorTest {

    @Test
    public void should_find_possessed_field() throws IllegalAccessException {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            AnnotationProcessor.throwIfPossessed(new SketchyClass(0, 666, ""));
        });
        assertEquals("Field is possessed by evil! PS Deus wult", exception.getMessage());
    }

    @Test
    public void should_not_find_possessed_field() throws IllegalAccessException {
        AnnotationProcessor.throwIfPossessed(new SketchyClass(666, 20, "666"));
    }

}
