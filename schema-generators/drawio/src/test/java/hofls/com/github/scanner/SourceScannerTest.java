package hofls.com.github.scanner;

import hofls.com.github.scanner.entity.UserAccount;
import hofls.com.github.schema.SchemaGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SourceScannerTest {

    @Test
    void scanEntity() {
        var entities = SourceScanner.readAllFromSource(UserAccount.class);

        entities.forEach(entity -> {
            System.out.println("Entity: " + entity.englishName() + ", Type: " + entity.type());
            entity.fields().forEach(f ->
                    System.out.println("  Field: [Cyrillic: " + f.cyrillicName() +
                            ", English: " + f.englishName() +
                            ", Type: " + f.type() + "]")
            );
        });
    }

}
