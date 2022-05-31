package hofls.com.github.generics.nested;

import lombok.val;

import java.util.Collections;

public class RestController {

    public ApiResponse<Page<User>> findUserById(Long id) {
        val users = Collections.singletonList(new User());
        val page = new Page<>(users);
        val response = new ApiResponse<>(page);
        return response;
    }
}
