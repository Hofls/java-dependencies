package hofls.com.github.rest.files;

import org.apache.commons.io.IOUtils;
import org.springframework.http.ContentDisposition;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

public class HttpServletResponseUtils {

    public static void streamToResponse(HttpServletResponse response, ByteArrayOutputStream baos, String filename) {
        try {
            // Works only for english:
            // response.setHeader("Content-Disposition", "attachment; filename=hello-world.wut");

            // Universal approach:
            ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
                    .filename(filename, StandardCharsets.UTF_8)
                    .build();
            response.setHeader("Content-Disposition", contentDisposition.toString());
            response.setContentLength(baos.size());
            IOUtils.write(baos.toByteArray(), response.getOutputStream());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
