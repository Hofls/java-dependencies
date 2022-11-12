package hofls.com.github;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.junit.jupiter.api.Test;

class JwtDemoTest {

    @Test
    void jwt_lifecycle() throws Exception {
        JwtDemo jwtDemo = new JwtDemo();
        String jwt = jwtDemo.createJWT();
        Jws<Claims> claims = jwtDemo.decodeJWT(jwt);
    }

}

