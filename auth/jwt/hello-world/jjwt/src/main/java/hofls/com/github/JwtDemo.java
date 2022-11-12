package hofls.com.github;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.security.KeyPair;
import java.util.Date;

public class JwtDemo {

    private Key publicKey;
    private Key privateKey;

    public JwtDemo() throws Exception {
        KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);
        publicKey = keyPair.getPublic();
        privateKey = keyPair.getPrivate();
    }

    /** Create and encode JWT with private key */
    public String createJWT() {
        Date expiresAt = new Date(System.currentTimeMillis() + 1000 * 60);
        return Jwts.builder()
                .setIssuer("jjwt")
                .setSubject("1234567890")
                .setExpiration(expiresAt)
                .claim("name", "John Doe")
                .signWith(privateKey)
                .compact();
    }

    /** Decode JWT with public key */
    public Jws<Claims> decodeJWT(String jwt) {
        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(publicKey)
                .build()
                .parseClaimsJws(jwt);
        return claims;
    }

}
