package hofls.com.github;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.LocalDate;
import java.util.Date;

public class JwtDemo {

    private RSAPublicKey rsaPublicKey;
    private RSAPrivateKey rsaPrivateKey;

    public JwtDemo() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair keyPair = generator.generateKeyPair();
        rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
        rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
    }

    /** Create and encode JWT with private key */
    public String createJWT() {
        Algorithm algorithm = Algorithm.RSA256(rsaPrivateKey);
        Date expiresAt = new Date(System.currentTimeMillis() + 1000 * 60);
        return JWT.create()
                .withIssuer("auth0")
                .withSubject("1234567890")
                .withExpiresAt(expiresAt)
                .withClaim("name", "John Doe")
                .sign(algorithm);
    }

    /** Decode JWT with public key */
    public DecodedJWT decodeJWT(String jwt) {
        Algorithm algorithm = Algorithm.RSA256(rsaPublicKey);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build();
        return verifier.verify(jwt);
    }

}
