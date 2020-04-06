package hofls.com.github;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextGeneratorTest {

    @Test
    public void generateTest() {
        assertEquals("abc", TextGenerator.generate(1));
        // assertEquals("def", TextGenerator.generate(0));
        // ^uncomment this code, if you want 'pitest' to pass
    }
}
