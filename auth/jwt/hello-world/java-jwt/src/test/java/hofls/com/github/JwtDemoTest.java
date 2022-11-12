package hofls.com.github;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JwtDemoTest {

    @Test
    void jwt_lifecycle() throws Exception {
        JwtDemo jwtDemo = new JwtDemo();
        String jwt = jwtDemo.createJWT();
        DecodedJWT decodedJWT = jwtDemo.decodeJWT(jwt);
    }

}

