package hofls.com.github.scanner;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.EnumDeclaration;
import hofls.com.github.schema.SchemaGenerator;

import java.nio.file.Path;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SourceScanner {

    public static List<SchemaGenerator.DBEntity> readAllFromSource(Class<?> clazz) {
        List<SchemaGenerator.DBEntity> entities = new ArrayList<>();

        // 1. Process the main Entity
        SchemaGenerator.DBEntity mainEntity = readFromSource(clazz);
        entities.add(mainEntity);

        // 2. Use Reflection to find the actual field types
        for (var field : clazz.getDeclaredFields()) {
            Class<?> fieldType = field.getType();

            // Check if the field is an Enum
            if (fieldType.isEnum()) {
                entities.add(readEnum(fieldType));
            }
        }

        return entities;
    }

    private static SchemaGenerator.DBEntity readFromSource(Class<?> clazz) {
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
                        return new SchemaGenerator.DBField(comment, v.getNameAsString(), v.getTypeAsString());
                    })).toList();

            return new SchemaGenerator.DBEntity(classComment, clazz.getSimpleName(), fields, "class");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static SchemaGenerator.DBEntity readEnum(Class<?> enumClazz) {
        try {
            Path path = getSourcePath(enumClazz);
            var cu = StaticJavaParser.parse(path);
            EnumDeclaration enumDecl = cu.getEnumByName(enumClazz.getSimpleName())
                    .orElseThrow(() -> new RuntimeException("Enum not found"));

            // Extract enum-level comment
            String enumComment = extractComment(enumDecl);

            var enumFields = enumDecl.getEntries().stream().map(entry -> {
                String cyrillicName = entry.getArguments().isNonEmpty()
                        ? entry.getArguments().get(0).toString().replace("\"", "")
                        : entry.getNameAsString();

                String englishName = entry.getNameAsString();

                return new SchemaGenerator.DBField(cyrillicName, englishName, null);
            }).toList();

            return new SchemaGenerator.DBEntity(enumComment, enumClazz.getSimpleName(), enumFields, "enum");
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