package hofls.com.github.file;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileToString {

    public String getRootReadme() throws IOException {
        String path = new File("../README.md").getAbsolutePath();
        return new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        // for new java version - return Files.readString(Paths.get(path));
    }

}
