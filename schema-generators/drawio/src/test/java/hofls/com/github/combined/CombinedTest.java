package hofls.com.github.combined;

import hofls.com.github.scanner.PackageScanner;
import hofls.com.github.scanner.SourceScanner;
import hofls.com.github.schema.SchemaGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class CombinedTest {

    @Test
    void classesToDrawio() {
        var classes = PackageScanner.findClassesInPackage("hofls.com.github.scanner.entity");
        var tables = new ArrayList<SchemaGenerator.DBEntity>();
        for (var clazz : classes) {
            tables.addAll(SourceScanner.readAllFromSource(clazz));
        }
        SchemaGenerator.generate(tables);
    }

}
