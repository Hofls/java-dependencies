package hofls.com.github.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;

@RequestMapping("/file")
@Tag(name = "file-controller", description = "Files example (upload/download)")
@RestController
public class FileController {

    // TODO - method "uploadFile"

    @Operation(summary = "Get file")
    @GetMapping("")
    void getFile(HttpServletResponse response) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write("Greetings!".getBytes());

        response.setHeader("Content-Disposition", "attachment; filename=hello-world.wut");
        response.setContentLength(baos.size());
        IOUtils.write(baos.toByteArray(), response.getOutputStream());
    }

}
