package hofls.com.github.clone;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class ObjectToCloneTest {

    @Test
    public void should_deep_clone_object() {
        ObjectToClone original = new ObjectToClone();
        original.getSubObjects().add(new ObjectToClone.SubObject(34L));

        /** Creates deep copy (deep clone) of an object */
        ObjectToClone cloned = SerializationUtils.clone(original);

        assertNotSame(original, cloned);
        assertNotSame(original.getSubObjects(), cloned.getSubObjects());
        assertEquals(original.getSubObjects().get(0), cloned.getSubObjects().get(0));
    }
}
