package com.github.hofls;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JwtDemoTest {

    @Test
    void jwt_lifecycle() throws Exception {
        JwtDemo jwtDemo = new JwtDemo();
        String jwt = jwtDemo.createJWT();
        DecodedJWT decodedJWT = jwtDemo.decodeJWT(jwt);
        assertEquals("John Doe", decodedJWT.getClaim("name").asString());
    }

}
