package hofls.com.github.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileRepository {

    // GOOD - callers not forced to handle anything, but they still can
    public FileInputStream readFile_GOOD()  {
        try {
            File file = new File("not_existing_file.txt");
            return new FileInputStream(file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // BAD - each caller forced to handle exception, event if most of them dont care about it
    public FileInputStream readFile_BAD() throws FileNotFoundException {
        File file = new File("not_existing_file.txt");
        return new FileInputStream(file);
    }

}
