package hofls.com.github.annotation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotationProcessorTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void should_find_possessed_field() throws IllegalAccessException {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Field is possessed by evil! PS Deus wult");
        AnnotationProcessor.throwIfPossessed(new SketchyClass(0, 666, ""));
    }

    @Test
    public void should_not_find_possessed_field() throws IllegalAccessException {
        AnnotationProcessor.throwIfPossessed(new SketchyClass(666, 20, "666"));
    }

}
