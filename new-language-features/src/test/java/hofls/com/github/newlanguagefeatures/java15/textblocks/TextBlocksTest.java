package hofls.com.github.newlanguagefeatures.java15.textblocks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TextBlocksTest {

    @Test
    void testGetText() {
        String expected = """
              <html>
                  <body>
                      <p>Hello, world</p>
                  </body>
              </html>
              """;

        Assertions.assertEquals(expected, TextBlocks.getText());
    }
}
