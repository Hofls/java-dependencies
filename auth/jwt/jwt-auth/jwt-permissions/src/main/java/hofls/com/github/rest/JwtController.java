package hofls.com.github.rest;

import hofls.com.github.jwt.JwtService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * In real project this controller would be located in auth service. <br>
 * Keys and JWT tokens would be generated automatically (look at "jwt/hello-world" package)
 * There would be method that takes login and password, checks them and returns JWT
 */
@RequestMapping("/jwt-controller")
@RestController
public class JwtController {

    @Operation(summary = "Create JWT")
    @GetMapping("create-token")
    String createJWT() {
        return JwtService.createJWT();
    }

}
