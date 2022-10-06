package hofls.com.github.utils;

import lombok.experimental.UtilityClass;
import org.apache.cxf.helpers.IOUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@UtilityClass
public class FileUtils {

    // FileUtils.fileToList("/documents.txt");
    public List<String> fileToList(String path) throws Exception {
        var scanner = new Scanner(fileToString(path));
        var list = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        scanner.close();
        return list;
    }

    public String fileToString(String path) throws Exception {
        return IOUtils.toString(FileUtils.class.getResourceAsStream(path));
    }
}
