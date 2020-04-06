package hofls.com.github.rest.token;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TokenService {

    private Map<String, List<GrantedAuthority>> tokens = new HashMap<>();

    public String generateToken(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add((GrantedAuthority) () -> role);
        }
        String token = UUID.randomUUID().toString();;
        tokens.put(token, authorities);
        return token;
    }

    public Map<String, List<GrantedAuthority>> getTokens() {
        return tokens;
    }

}
