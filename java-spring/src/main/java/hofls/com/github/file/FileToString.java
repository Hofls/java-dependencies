package hofls.com.github.file;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileToString {

    public String getRootReadme() throws IOException {
        File file = new File("../README.md");
        String path = file.getAbsolutePath();
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        return new String(bytes, StandardCharsets.UTF_8);
    }

}
