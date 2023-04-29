package hofls.com.github.rest.files;

import org.apache.commons.io.IOUtils;
import org.springframework.http.ContentDisposition;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HttpServletResponseUtils {

    public static ResponseEntity<byte[]> toResponse(ByteArrayOutputStream baos, String fileName) throws IOException {
        // Universal approach:
        ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
                .filename(fileName, StandardCharsets.UTF_8)
                .build();

        return ResponseEntity.ok()
                .header("Content-Disposition", contentDisposition.toString())
                // Works only for english - .header("Content-Disposition", "attachment; filename=\"" + fileName + ".wut\"")
                // Also may be necessary to set type - .contentType(MediaType.APPLICATION_PDF)
                .body(baos.toByteArray());
    }

    public static void streamToResponse(HttpServletResponse response, ByteArrayOutputStream baos, String filename) {
        try {
            // Works only for english:
            // response.setHeader("Content-Disposition", "attachment; filename=hello-world.wut");

            // Universal approach:
            ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
                    .filename(filename, StandardCharsets.UTF_8)
                    .build();
            response.setHeader("Content-Disposition", contentDisposition.toString());
            // Also may be necessary to set type - response.setContentType("application/pdf");
            response.setContentLength(baos.size());
            IOUtils.write(baos.toByteArray(), response.getOutputStream());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
