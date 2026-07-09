package com.github.hofls.combined;

import com.github.hofls.scanner.PackageScanner;
import com.github.hofls.scanner.SourceScanner;
import com.github.hofls.schema.SchemaGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class CombinedTest {

    @Test
    void classesToDrawio() {
        var classes = PackageScanner.findClassesInPackage("com.github.hofls.scanner.entity");
        var tables = new ArrayList<SchemaGenerator.DBEntity>();
        for (var clazz : classes) {
            tables.addAll(SourceScanner.readAllFromSource(clazz));
        }
        SchemaGenerator.generate(tables);
    }

}
