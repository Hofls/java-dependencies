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

            var fields = classDecl.getFields().stream()
                    .flatMap(fd -> fd.getVariables().stream().map(v -> {
                        String comment = fd.getJavadocComment()
                                .map(c -> c.parse().toText().trim())
                                .orElse(v.getNameAsString());
                        return new SchemaGenerator.DBField(comment, v.getNameAsString(), v.getTypeAsString());
                    })).toList();

            return new SchemaGenerator.DBEntity(clazz.getSimpleName(), fields);
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

            var enumFields = enumDecl.getEntries().stream().map(entry -> {
                // Extract the constructor argument (e.g., "Not on the network")
                // This assumes the first argument is the 'title'
                String cyrillicName = entry.getArguments().isNonEmpty()
                        ? entry.getArguments().get(0).toString().replace("\"", "")
                        : entry.getNameAsString();

                String englishName = entry.getNameAsString();

                // type = null as requested
                return new SchemaGenerator.DBField(cyrillicName, englishName, null);
            }).toList();

            return new SchemaGenerator.DBEntity(enumClazz.getSimpleName(), enumFields);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Path getSourcePath(Class<?> clazz) {
        String userDir = System.getProperty("user.dir");
        return Paths.get(userDir, "src", "main", "java",
                clazz.getName().replace(".", "/") + ".java");
    }
}