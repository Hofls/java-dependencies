package hofls.com.github.scanner;

import hofls.com.github.scanner.entity.UserAccount;
import hofls.com.github.schema.SchemaGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SourceScannerTest {

    @Test
    void generate() throws Exception {
        var table = SourceScanner.readFromSource(UserAccount.class);
        System.out.println(table);
    }

}
