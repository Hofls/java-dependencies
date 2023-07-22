package hofls.com.github.rest.files;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;

@RequestMapping("/file")
@Tag(name = "file-controller", description = "Files example (upload/download)")
@RestController
public class FileController {

    // Easiest method to download a file - just put file in resources/static folder
    // Accessible via http://localhost:8080/hello.json

    @Operation(summary = "Get file")
    @GetMapping("/main")
    ResponseEntity<byte[]> getFile() throws Exception {
        ByteArrayOutputStream arrayStream = new ByteArrayOutputStream();
        arrayStream.write("Greetings!".getBytes());

        return HttpServletResponseUtils.toResponse(arrayStream, "привет.wut");
    }

    @Operation(summary = "Get file (alternative)")
    @GetMapping("/alternative")
    void getFile(HttpServletResponse response) throws Exception {
        ByteArrayOutputStream arrayStream = new ByteArrayOutputStream();
        arrayStream.write("Greetings!".getBytes());

        HttpServletResponseUtils.streamToResponse(response, arrayStream, "привет.wut");
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    public ResponseEntity<String> uploadFile(
            @RequestBody MultipartFile file) {
        return ResponseEntity.ok("Received file: " + file.getOriginalFilename());
    }

}
