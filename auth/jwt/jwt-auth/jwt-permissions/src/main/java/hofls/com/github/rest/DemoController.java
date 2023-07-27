package hofls.com.github.rest;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/demo")
@RestController
public class DemoController {

    @Operation(summary = "Call this endpoint from swagger-ui!")
    @GetMapping
    public String swaggerEndpoint() {
        return "Jwt token is correct! (checked with public key from /openid-connect/certs)\n" +
            "Also has necessary permissions (CHECK_ALERTS) \n" +
            "Very nice!";
    }

}
