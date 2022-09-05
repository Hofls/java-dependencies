package hofls.com.github.junit;

import de.redsix.pdfcompare.PdfComparator;
import org.junit.jupiter.api.Assertions;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class PdfTestUtils {

    public static void assertEqualPdf(java.io.ByteArrayOutputStream actualPdf, String path) throws Exception {
        String TESTS_RESULT_FOLDER = "src/test/resources/pdf-test-results/";
        String expectedPath = TESTS_RESULT_FOLDER + path + "-expected.pdf";
        String actualPath = TESTS_RESULT_FOLDER + path + "-actual.pdf";
        String comparisonPath = TESTS_RESULT_FOLDER + path + "-comparison";

        try (OutputStream outputStream = new FileOutputStream(actualPath)) {
            actualPdf.writeTo(outputStream);
        }

        PdfComparator comparator = new PdfComparator(expectedPath, actualPath);
        boolean isEquals = comparator.compare().writeTo(comparisonPath);
        if (!isEquals) {
            Assertions.fail("Pdf files are different! For more details look at " + comparisonPath + ".pdf");
        }
    }

}
