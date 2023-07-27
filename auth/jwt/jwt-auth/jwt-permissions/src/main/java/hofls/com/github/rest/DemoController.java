package hofls.com.github.rest;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/demo")
@RestController
public class DemoController {

    @Autowired
    private HttpServletRequest httpRequest;

    @Operation(summary = "Call this endpoint from swagger-ui!")
    @GetMapping("/jwt-with-privilege")
    public String jwtWithPrivilege() {
        checkPrivilege("CHECK_ALERTS"); // TODO - replace with @PreAuthorize("hasAuthority('CHECK_ALERTS')")
        return "Jwt token is correct! (checked with public key from /openid-connect/certs)\n" +
            "Also has necessary permissions (CHECK_ALERTS) \n" +
            "Very nice!";
    }

    @Operation(summary = "Call this endpoint from swagger-ui!")
    @GetMapping("/jwt-without-privilege")
    public String jwtWithoutPrivilege() {
        checkPrivilege("DELETE_ALL_DATA"); // TODO - replace with @PreAuthorize("hasAuthority('DELETE_ALL_DATA')")
        return "You won't see this text form swagger-ui";
    }

    private void checkPrivilege(String privilege) {
        String jwtText = httpRequest.getHeader("Authorization").substring(7); // Substring to exclude "Bearer"
        DecodedJWT decodedJWT = JWT.decode(jwtText);
        List<String> privileges = decodedJWT.getClaims().get("authorization").asList(String.class);
        if (!privileges.contains(privilege)) {
            throw new RuntimeException("Permission " + privilege + " not found in JWT " + privileges);
        }
    }

}
