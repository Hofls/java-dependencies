package hofls.com.github;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class Excel {

    public static void fillSheet() throws Exception {
        Workbook workbook = new XSSFWorkbook(Excel.class.getResourceAsStream("/template.xlsx"));
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.createRow(1);
        row.createCell(0).setCellValue("Hello world");
        row.createCell(1).setCellValue("John");

        FileOutputStream outputStream = new FileOutputStream("result.xlsx");
        workbook.write(outputStream);
        workbook.close();
    }

}
