package hofls.com.github;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Objects;

public class ExcelTestUtils {

    public static void throwIfDifferent(String expectedPath, String actualPath) throws Exception {
        Workbook expectedBook = new XSSFWorkbook(Excel.class.getResourceAsStream(expectedPath));
        Workbook actualBook = new XSSFWorkbook(Excel.class.getResourceAsStream(actualPath));
        int expectedSheets = expectedBook.getNumberOfSheets();
        int actualSheets = actualBook.getNumberOfSheets();

        // Compare the number of sheets in the two workbooks
        if (expectedSheets != actualSheets) {
            throw new AssertionError("Expected sheets count - " + expectedSheets + ", actual - " + actualSheets);
        }

        // Compare the contents of each sheet in the two workbooks
        for (int i = 0; i < expectedSheets; i++) {
            Sheet expectedSheet = expectedBook.getSheetAt(i);
            Sheet actualSheet = actualBook.getSheetAt(i);

            // Compare the number of rows in the two sheets
            if (expectedSheet.getLastRowNum() != actualSheet.getLastRowNum()) {
                throw new AssertionError("Expected number of rows in sheet " + (i+1) + " is " + expectedSheet.getLastRowNum() + ", actual - " + actualSheet.getLastRowNum());
            }

            // Compare the contents of each cell in the two sheets
            for (int j = 0; j <= expectedSheet.getLastRowNum(); j++) {
                short expectedRowLength = expectedSheet.getRow(j).getLastCellNum();
                short actualRowLength = actualSheet.getRow(j).getLastCellNum();
                if (expectedRowLength != actualRowLength) {
                    throw new AssertionError("Expected number of columns in row " + j + " is " + expectedRowLength + ", actual - " + actualRowLength);
                }
                for (int k = 0; k < expectedSheet.getRow(j).getLastCellNum(); k++) {
                    Cell expectedCell = expectedSheet.getRow(j).getCell(k);
                    Cell actualCell = actualSheet.getRow(j).getCell(k);
                    String expectedValue = expectedCell != null ? getCellContent(expectedCell) : "";
                    String actualValue = actualCell != null ? getCellContent(actualCell) : "";
                    if (!Objects.equals(expectedValue, actualValue)) {
                        throw new AssertionError("Expected content of cell (" + (j+1) + "," + (k+1) + ") in sheet " + (i+1) + " is " + expectedValue + ", actual - " + actualValue);
                    }
                }
            }
        }
    }

    private static String getCellContent(Cell cell) {
        if (cell == null) {
            return "";
        }
        if (cell.getCellType()== CellType.STRING) {
            return cell.getStringCellValue();
        } else if(cell.getCellType()==CellType.NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        } else {
            throw new RuntimeException("Unknown cell type");
        }
    }



}
