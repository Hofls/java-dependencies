package hofls.com.github.rest.token;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = {"token-controller"})
@RequestMapping("/tokens")
@RestController
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @ApiOperation(value = "Get all registered users", notes = "")
    @GetMapping
    public Map<String, List<GrantedAuthority>> getAll() {
        return tokenService.getTokens();
    }

    @ApiOperation(value = "Register new token", notes = "")
    @PostMapping
    public String generateToken(@RequestBody GenerateTokenRequest request) {
        return tokenService.generateToken(request.getRoles());
    }

}
