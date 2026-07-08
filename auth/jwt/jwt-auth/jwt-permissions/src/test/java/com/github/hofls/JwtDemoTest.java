package com.github.hofls;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.github.hofls.jwt.JwtService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JwtDemoTest {

    @Test
    public void jwt_lifecycle() throws Exception {
        String jwt = JwtService.createJWT();
        DecodedJWT decodedJWT = JwtService.decodeJWT(jwt);
        assertEquals("John Doe", decodedJWT.getClaim("name").asString());
    }

}

