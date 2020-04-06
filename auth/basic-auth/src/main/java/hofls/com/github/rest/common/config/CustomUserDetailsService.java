package hofls.com.github.rest.common.config;

import org.apache.commons.lang3.SerializationUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private Map<String, UserDetails> registeredUsers = new HashMap<>();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return SerializationUtils.clone(registeredUsers.get(username)); // without cloning - password is nullified by Spring
    }

    public void addUser(String username, String password, List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add((GrantedAuthority) () -> role);
        }
        String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = new User(username, encryptedPassword,
                true, true, true, true, authorities);
        registeredUsers.put(username, user);
    }

    public Map<String, UserDetails> getUsers() {
        return registeredUsers;
    }

}
