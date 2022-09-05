package hofls.com.github.report;

import java.io.*;

public class MonthlyReport {

    public ByteArrayOutputStream createReport() throws Exception {
        // Imagine that it actually generates PDF report
        return getBytes("report.pdf");
    }

    public ByteArrayOutputStream getBytes(String fileName) throws Exception {
        byte[] buffer = new byte[4096];
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int bytes = 0;
        while ((bytes = bis.read(buffer, 0, buffer.length)) > 0) {
            baos.write(buffer, 0, bytes);
        }
        baos.close();
        bis.close();

        return baos;
    }


}
