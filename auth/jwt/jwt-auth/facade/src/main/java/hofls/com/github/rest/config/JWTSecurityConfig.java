package hofls.com.github.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class JWTSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/swagger-ui/**").permitAll()
                .antMatchers("/v3/api-docs/**").permitAll()
                .antMatchers("/auth-server/**").permitAll();

        /** Check JWT for each received request: */
        http.authorizeRequests(authz -> authz.anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt());
    }


}
