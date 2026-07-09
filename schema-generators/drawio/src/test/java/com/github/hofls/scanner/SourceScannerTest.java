package com.github.hofls.scanner;

import com.github.hofls.scanner.entity.UserAccount;
import com.github.hofls.schema.SchemaGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SourceScannerTest {

    @Test
    void scanEntity() {
        var entities = SourceScanner.readAllFromSource(UserAccount.class);

        entities.forEach(entity -> {
            System.out.println("Cyrillic: " + entity.cyrillicName() + ", Entity: " + entity.englishName() + ", Type: " + entity.type());
            entity.fields().forEach(f ->
                    System.out.println("  Field: [Cyrillic: " + f.cyrillicName() +
                            ", English: " + f.englishName() +
                            ", Type: " + f.type() + "]")
            );
        });
    }

}
