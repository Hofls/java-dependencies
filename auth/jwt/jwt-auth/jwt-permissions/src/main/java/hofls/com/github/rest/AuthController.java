package hofls.com.github.rest;

import hofls.com.github.jwt.JwtService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * In real project there would be a method that takes login and password, checks them and returns JWT
 */
@RequestMapping("/auth-server")
@RestController
public class AuthController {

    @Operation(summary = "Get public key (JWKS)")
    @GetMapping("openid-connect/certs")
    CertResponse createJWT() {
        return JwtService.getPublicJWK();
    }

}
