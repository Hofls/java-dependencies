package hofls.com.github;

import com.github.javaparser.StaticJavaParser;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CommentExtractor {

    public record DBEntity(String comment, String englishName, List<DBField> fields, String type) {}

    public record DBField(String comment, String englishName, String type) {}

    public static DBEntity readFromSource(Class<?> clazz) {
        try {
            Path path = getSourcePath(clazz);
            var cu = StaticJavaParser.parse(path);
            var classDecl = cu.getClassByName(clazz.getSimpleName())
                    .orElseThrow(() -> new RuntimeException("Class not found"));

            // Extract class-level comment
            String classComment = extractComment(classDecl);

            var fields = classDecl.getFields().stream()
                    .flatMap(fd -> fd.getVariables().stream().map(v -> {
                        String comment = fd.getJavadocComment()
                                .map(c -> c.parse().toText().trim())
                                .orElse(v.getNameAsString());
                        return new DBField(comment, v.getNameAsString(), v.getTypeAsString());
                    })).toList();

            return new DBEntity(classComment, clazz.getSimpleName(), fields, "class");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Helper to extract Javadoc or a regular comment from a declaration.
     */
    private static String extractComment(com.github.javaparser.ast.body.TypeDeclaration<?> decl) {
        return decl.getJavadocComment()
                .map(comment -> comment.parse().toText().trim()) // Clean Javadoc
                .orElseGet(() -> decl.getComment()
                        .map(comment -> comment.getContent().trim()) // Fallback to normal comment
                        .orElse(decl.getNameAsString())); // Fallback to class name
    }

    private static Path getSourcePath(Class<?> clazz) {
        String userDir = System.getProperty("user.dir");
        return Paths.get(userDir, "src", "main", "java",
                clazz.getName().replace(".", "/") + ".java");
    }
}