package hofls.com.github.rest.demo;

import hofls.com.github.rest.feign.FeignDemo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/demo")
@RestController
public class DemoController {

    @Autowired
    private FeignDemo feignDemo;

    @Operation(summary = "Call this endpoint from swagger-ui")
    @GetMapping
    public String swaggerEndpoint() {
        return feignDemo.feignEndpoint();
    }

    @Operation(summary = "Endpoint for feign")
    @PostMapping
    public String feignEndpoint(HttpServletRequest httpRequest) {
        return "Feign send request with auth header - " + httpRequest.getHeader("Authorization");
    }

}
