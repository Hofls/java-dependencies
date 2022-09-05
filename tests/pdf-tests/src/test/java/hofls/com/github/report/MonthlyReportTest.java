package hofls.com.github.report;

import hofls.com.github.junit.PdfTestUtils;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

class MonthlyReportTest {

    @Test
    void createReport() throws Exception {
        ByteArrayOutputStream actual = new MonthlyReport().createReport();
        PdfTestUtils.assertEqualPdf(actual, "monthly/createReport");
    }

}