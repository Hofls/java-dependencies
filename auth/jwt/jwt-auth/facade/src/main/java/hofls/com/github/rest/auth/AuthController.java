package hofls.com.github.rest.auth;

import hofls.com.github.rest.demo.FeignDemo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * In real project this controller would be located in auth service. <br>
 * Keys and JWT tokens would be generated automatically (look at "jwt/hello-world" package)
 * There would be method that takes login and password, checks them and returns JWT
 */
@RequestMapping("/auth-server")
@RestController
public class AuthController {

    @Autowired
    private FeignDemo feignDemo;

    @Operation(summary = "Get public key (JWKS)")
    @GetMapping("openid-connect/certs")
    String getPubKeys() {
        return "{\n" +
                "  \"keys\": [\n" +
                "    {\n" +
                "      \"use\": \"sig\",\n" +
                "      \"kty\": \"RSA\",\n" +
                "      \"kid\": \"4439eba47e735e892cf8f4d1efcd0e4d\",\n" +
                "      \"alg\": \"RS256\",\n" +
                "      \"n\": \"v-dI_C4d3FIwxZ85EpDoDkpONvjdcbTRKULvyu7evm40e4o41AvPhK5tPU8pYbXFd8GFTnZ7T_cNy2xECYLl5OAm0YAgNh7ijwjDPHOtymEPUvqq7clWbJNiygvDQjXm89pk4I8cPRxXXlhaeh6SR1pPTICL4Ibw3AZGT-YeddKKYI4hCFQEAw1XKKD1trh32AxBYg1O_dyuY--Lt7Yxt7ZNDD6frjTyu6oeNAe5vCUta6PavwFTixPSjP869lnYdZguPthGALvdX_gkkAWI6JnHX8zAWkg3WjIp9gxy8hL44mXWUHcw8D9LQatbZeo5sz4D2P2I61AgFHP-RpW8lj_405S5IoNmYwy4luT_V5KWDGzIzGJ1lPq-JwEY8gzTq1b7wy0yTo2YmE4MNx7Z08hQ7RqeFjbPADz-XwKaC5oQHcdh_FaMVkSpTCoV1_7inqjRacRag6_N15LOIeVRsfimS26wJ5gHJvinAO2qPRAJAEM9KA-kkyt-My82LJ8R\",\n" +
                "      \"e\": \"AQAB\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

}
