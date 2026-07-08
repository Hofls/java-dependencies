package com.github.hofls;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;

public class JwtDemo {

    private PublicKey publicKey;
    private PrivateKey privateKey;

    public JwtDemo() throws Exception {
        KeyPair keyPair = Jwts.SIG.RS256.keyPair().build();
        publicKey = keyPair.getPublic();
        privateKey = keyPair.getPrivate();
    }

    /** Create and encode JWT with private key */
    public String createJWT() {
        Date expiresAt = new Date(System.currentTimeMillis() + 1000 * 60);
        return Jwts.builder()
                .issuer("jjwt")
                .subject("1234567890")
                .expiration(expiresAt)
                .claim("name", "John Doe")
                .signWith(privateKey)
                .compact();
    }

    /** Decode JWT with public key */
    public Jws<Claims> decodeJWT(String jwt) {
        return Jwts.parser()
                .verifyWith(publicKey)
                .build()
                .parseSignedClaims(jwt);
    }

}
