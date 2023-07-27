package hofls.com.github.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import hofls.com.github.rest.CertResponse;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.crypto.util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;

import java.io.StringWriter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
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
        Date expiresAt = new Date(System.currentTimeMillis() + 1000 * 60);
        return JWT.create()
                .withIssuer("http://localhost:8080/auth-server/")
                .withSubject("1234567890")
                .withExpiresAt(expiresAt)
                .withClaim("name", "John Doe")
                .withClaim("authorization", Arrays.asList("CHECK_ALERTS", "DELETE_USERS"))
                .sign(algorithm);
    }

    /** Decode JWT with public key */
    public static DecodedJWT decodeJWT(String jwt) {
        Algorithm algorithm = Algorithm.RSA256(rsaPublicKey);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build();
        return verifier.verify(jwt);
    }

}
