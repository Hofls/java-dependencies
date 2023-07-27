package hofls.com.github.rest;

import hofls.com.github.aspects.RequiresPermission;
import hofls.com.github.jwt.JwtService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/demo")
@RestController
public class DemoController {

    @Operation(summary = "OK - direct call")
    @GetMapping("/jwt-with-privilege")
    public String jwtWithPrivilege() {
        JwtService.checkPermission("CHECK_ALERTS");
        return "Jwt token is correct! (checked with public key from /openid-connect/certs)\n" +
            "Also has necessary permissions (CHECK_ALERTS) \n" +
            "Very nice!";
    }

    @Operation(summary = "No privilege - direct call")
    @GetMapping("/jwt-without-privilege")
    public String jwtWithoutPrivilege() {
        JwtService.checkPermission("DELETE_ALL_DATA");
        return "You won't see this text form swagger-ui";
    }

    @Operation(summary = "OK - annotation")
    @RequiresPermission("CHECK_ALERTS")
    @GetMapping("/jwt-with-privilege/aspect")
    public String jwtWithPrivilegeAspect() {
        return "Jwt token is correct! (checked with public key from /openid-connect/certs)\n" +
                "Also has necessary permissions (CHECK_ALERTS) \n" +
                "Very nice!";
    }

    @Operation(summary = "No privilege - annotation")
    @RequiresPermission("DELETE_ALL_DATA")
    @GetMapping("/jwt-without-privilege/aspect")
    public String jwtWithoutPrivilegeAspect() {
        return "You won't see this text form swagger-ui";
    }

    // TODO - @PreAuthorize("hasAuthority('CHECK_ALERTS')")

}
