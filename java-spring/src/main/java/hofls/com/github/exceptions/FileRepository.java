package hofls.com.github.exceptions;

import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/** Checked VS Unchecked exceptions */
public class FileRepository {

    // GOOD - callers not forced to handle anything, but they still can
    public FileInputStream readFile_GOOD()  {
        try {
            File file = new File("not_existing_file.txt");
            return new FileInputStream(file);
        } catch (Exception e) {
            throw new RuntimeException(e); // or @SneakyThrows
        }
    }

    // BAD - each caller forced to handle exception, event if most of them dont care about it
    public FileInputStream readFile_BAD() throws FileNotFoundException {
        File file = new File("not_existing_file.txt");
        return new FileInputStream(file);
    }

    // GOOD - callers not forced to check list
    public boolean containsSpecial_GOOD(List<Integer> list) {
        if (CollectionUtils.isEmpty(list)) {
            return false;
        }
        return list.contains(777);
    }

    // BAD 1 - callers forced to make sure list is not empty
    public boolean containsSpecial_BAD1(List<Integer> list) {
        return list.contains(777);
    }

    // BAD 2- callers forced to make sure list is not empty
    public boolean containsSpecial_BAD2(List<Integer> list) {
        if (CollectionUtils.isEmpty(list)) {
            throw new IllegalArgumentException("List should not be empty");
        }
        return list.contains(777);
    }

}
