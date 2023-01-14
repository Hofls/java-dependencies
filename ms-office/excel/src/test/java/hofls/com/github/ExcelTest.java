package hofls.com.github;

import org.junit.jupiter.api.Test;

class ExcelTest {

    @Test
    void fillSheet() throws Exception {
        Excel.fillSheet();
    }

    @Test
    void throwIfDifferent() throws Exception {
        ExcelTestUtils.throwIfDifferent("/templateA.xlsx", "/templateB.xlsx");
    }

}

