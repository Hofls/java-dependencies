package hofls.com.github.file;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class FileToStringTest {
    FileToString fileToString = new FileToString();

    @Test
    void testGetRootReadme() throws IOException {
        String result = fileToString.getRootReadme();
        Assertions.assertTrue(result.startsWith("# java-dependencies-examples"));
    }
}
