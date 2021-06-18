package hofls.com.github.reflection;

import hofls.com.github.reflection.schemas.DocSchema;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Alternative - manually maintaning list of classes
 * Each time you add a new class - you need to update list
 * Automatically is better than manually
 */
class ValidateAllSchemasTest {

    @Test
    void testValidateAllSchemas() throws Exception {
        Reflections reflections = new Reflections("hofls.com.github.reflection");
        Set<Class<? extends DocSchema>> classes =
                reflections.getSubTypesOf(DocSchema.class);
        int validatedSchemas = 0;
        for (Class<? extends DocSchema> clazz : classes) {
            System.out.println("Validating schema " + clazz.getName());
            DocSchema schema = clazz.newInstance();
            SchemaValidator.throwIfInvalid(schema);
            validatedSchemas++;
        }
        assertEquals(2, validatedSchemas);
    }

}