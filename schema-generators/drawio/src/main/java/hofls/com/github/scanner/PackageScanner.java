package hofls.com.github.scanner;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PackageScanner {

    public static List<Class<?>> findClassesInPackage(String packagePath) {
        List<Class<?>> classes = new ArrayList<>();
        try {
            // 1. Convert package name to path
            String path = packagePath.replace('.', '/');
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            URL resource = classLoader.getResource(path);

            if (resource == null) {
                return classes; // Package not found
            }

            // 2. Turn the resource into a directory and scan files
            File directory = new File(resource.getFile());
            if (directory.exists()) {
                for (File file : directory.listFiles()) {
                    if (file.getName().endsWith(".class")) {
                        // Remove ".class" extension to get the name
                        String className = packagePath + "." + file.getName().substring(0, file.getName().length() - 6);
                        classes.add(Class.forName(className));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classes;
    }

}
