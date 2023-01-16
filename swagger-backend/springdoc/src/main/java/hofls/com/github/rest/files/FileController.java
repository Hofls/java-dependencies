package hofls.com.github.rest.files;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.io.IOUtils;
import org.springframework.http.ContentDisposition;
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
        ByteArrayOutputStream arrayStream = new ByteArrayOutputStream();
        arrayStream.write("Greetings!".getBytes());

        HttpServletResponseUtils.streamToResponse(response, arrayStream, "привет.wut");
    }

}
