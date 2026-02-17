package hofls.com.github.combined;

import hofls.com.github.scanner.PackageScanner;
import hofls.com.github.scanner.SourceScanner;
import hofls.com.github.scanner.entity.UserAccount;
import hofls.com.github.schema.SchemaGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CombinedTest {

    @Test
    void classesToDrawio() {
        var classes = PackageScanner.findClassesInPackage("hofls.com.github.scanner.entity");
        var tables = new ArrayList<SchemaGenerator.DBTable>();
        for (var clazz : classes) {
            tables.add(SourceScanner.readFromSource(clazz));
        }
        SchemaGenerator.generate(tables);
    }

}
