package hofls.com.github.rest.users;

import hofls.com.github.rest.common.config.CustomUserDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = {"users-controller"})
@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @ApiOperation(value = "Get all registered users", notes = "")
    @GetMapping
    public Map<String, UserDetails> getAll() {
        return userDetailsService.getUsers();
    }

    @ApiOperation(value = "Register a new user", notes = "")
    @PostMapping
    public void addUser(@RequestBody AddUserRequest request) {
        userDetailsService.addUser(request.getName(), request.getPassword(), request.getProfessions());
    }

}
