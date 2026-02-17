package hofls.com.github.scanner;

import com.github.javaparser.StaticJavaParser;
import hofls.com.github.schema.SchemaGenerator;

import java.nio.file.Path;

import java.nio.file.Paths;

public class SourceScanner {

    public static SchemaGenerator.DBTable readFromSource(Class<?> clazz) throws Exception {
        // 1. Get the project root directory
        String userDir = System.getProperty("user.dir");

        // 2. Build the path to the source file
        // Standard Gradle structure: src/main/java/com/example/UserAccount.java
        Path path = Paths.get(userDir, "src", "main", "java",
                clazz.getName().replace(".", "/") + ".java");

        var cu = StaticJavaParser.parse(path);
        var classDecl = cu.getClassByName(clazz.getSimpleName())
                .orElseThrow(() -> new RuntimeException("Class not found in source"));

        var fieldRecords = classDecl.getFields().stream()
                .flatMap(fd -> fd.getVariables().stream().map(v -> {
                    // Extract comment and clean up Javadoc stars/whitespace
                    String comment = fd.getJavadocComment()
                            .map(c -> c.parse().toText().trim())
                            .orElse(v.getNameAsString());

                    return new SchemaGenerator.DBField(comment, v.getNameAsString(), v.getTypeAsString());
                }))
                .toList();

        return new SchemaGenerator.DBTable(clazz.getSimpleName(), fieldRecords);
    }
}