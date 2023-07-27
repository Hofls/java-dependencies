package hofls.com.github;

import com.auth0.jwt.interfaces.DecodedJWT;
import hofls.com.github.rest.JwtDemo;
import org.junit.jupiter.api.Test;

class JwtDemoTest {

    @Test
    void jwt_lifecycle() throws Exception {
        JwtDemo jwtDemo = new JwtDemo();
        String jwt = jwtDemo.createJWT();
        DecodedJWT decodedJWT = jwtDemo.decodeJWT(jwt);
    }

}

