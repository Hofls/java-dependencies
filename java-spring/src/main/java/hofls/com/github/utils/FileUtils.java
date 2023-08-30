package hofls.com.github.utils;

import lombok.experimental.UtilityClass;
import org.apache.cxf.helpers.IOUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@UtilityClass
public class FileUtils {

    // FileUtils.fileToStrings("/documents.txt");
    public List<String> fileToStrings(String path) throws Exception {
        Scanner scanner = new Scanner(fileToString(path));
        List<String> list = new ArrayList<>();
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
