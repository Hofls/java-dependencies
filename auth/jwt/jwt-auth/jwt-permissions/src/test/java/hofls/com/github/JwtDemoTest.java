package hofls.com.github;

import com.auth0.jwt.interfaces.DecodedJWT;
import hofls.com.github.jwt.JwtService;
import org.junit.jupiter.api.Test;

class JwtDemoTest {

    @Test
    void jwt_lifecycle() throws Exception {
        String jwt = JwtService.createJWT();
        DecodedJWT decodedJWT = JwtService.decodeJWT(jwt);
    }

}

