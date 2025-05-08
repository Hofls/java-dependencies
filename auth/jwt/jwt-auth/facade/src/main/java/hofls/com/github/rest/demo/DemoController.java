package hofls.com.github.rest.demo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import feign.Feign;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/demo")
@RestController
public class DemoController {

    @Autowired
    private FeignDemo feignDemo;

    @Operation(summary = "Call this endpoint from swagger-ui!")
    @GetMapping
    public String swaggerEndpoint() {
        return feignDemo.feignEndpoint();
    }

    @Operation(summary = "Endpoint for feign")
    @PostMapping
    public String feignEndpoint(HttpServletRequest httpRequest) {
        String jwtText = httpRequest.getHeader("Authorization").substring(7); // Substring to exclude "Bearer"
        DecodedJWT decodedJWT = JWT.decode(jwtText);
        String sub = decodedJWT.getSubject();
        // Todo - replace this with annotation
        return "Extracted sub - " + sub + "\n" +
                "In the same way you can throw exception, if jwt doesnt contain necessary role/privilege \n" +
                "Feign sent request with auth header - " + jwtText;
    }

}
