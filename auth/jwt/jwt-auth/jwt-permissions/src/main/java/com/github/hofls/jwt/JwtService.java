package com.github.hofls.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import com.github.hofls.rest.CertResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.*;

public class JwtService {

    private static RSAPublicKey rsaPublicKey;
    private static RSAPrivateKey rsaPrivateKey;
    private static JWK jwk;

    static {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            KeyPair keyPair = generator.generateKeyPair();
            rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
            rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();

            jwk = new RSAKey.Builder(rsaPublicKey)
                    .keyUse(KeyUse.SIGNATURE)
                  //  .algorithm(JWSAlgorithm.RS256)
                    .keyID(UUID.randomUUID().toString())
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static CertResponse getPublicJWK() {
        List<Map<String, Object>> keyList = new ArrayList<>();
        keyList.add(jwk.toPublicJWK().toJSONObject());
        return new CertResponse(keyList);
    }


    /** Create and encode JWT with private key */
    public static String createJWT() {
        Algorithm algorithm = Algorithm.RSA256(rsaPrivateKey);
        return JWT.create()
                .withIssuer("http://localhost:8080/auth-server/")
                .withSubject("1234567890")
                //.withExpiresAt(expiresAt)
                .withClaim("name", "John Doe")
                .withClaim("permissions", Arrays.asList("CHECK_ALERTS", "DELETE_USERS"))
                .sign(algorithm);
    }

    /** Decode JWT with public key */
    public static DecodedJWT decodeJWT(String jwt) {
        Algorithm algorithm = Algorithm.RSA256(rsaPublicKey);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("http://localhost:8080/auth-server/")
                .build();
        return verifier.verify(jwt);
    }

    public static void checkPermission(String privilege) {
        HttpServletRequest httpRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String jwtText = httpRequest.getHeader("Authorization").substring(7); // Substring to exclude "Bearer"
        DecodedJWT decodedJWT = JWT.decode(jwtText);
        List<String> privileges = decodedJWT.getClaims().get("permissions").asList(String.class);
        if (!privileges.contains(privilege)) {
            throw new RuntimeException("Permission " + privilege + " not found in JWT " + privileges);
        }
    }

}
