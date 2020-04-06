package hofls.com.github.rest.auth;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"auth-controller"})
@RequestMapping("/auth")
@RestController
public class AuthController {

    @ApiOperation("Login")
    @PostMapping("login")
    public void fakeLogin(@ApiParam(example = "Minx") @RequestParam String username,
                          @ApiParam(example = "4321") @RequestParam String password) {
        throw new IllegalStateException("This method shouldn't be called. It's implemented by Spring Security filters.");
    }

    @ApiOperation("Logout")
    @PostMapping("logout")
    public void fakeLogout() {
        throw new IllegalStateException("This method shouldn't be called. It's implemented by Spring Security filters.");
    }
}
