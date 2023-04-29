package hofls.com.github.feign;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "file-service", url = "http://localhost:8080/")
public interface FileFeign {

    @Operation(summary = "Get file")
    @GetMapping("/file/main")
    ResponseEntity<byte[]> getFile();

}
