package hofls.com.github;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // Permits some pages for unauthorized user:
                .authorizeRequests(a -> a
                        .antMatchers("/", "/error", "/webjars/**").permitAll()
                        .anyRequest().authenticated()
                )
                // Overrides default behavior of redirecting to a login page:
                .exceptionHandling(e -> e
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                )
                // Permits access to default "/logout" endpoint:
                .logout(l -> l
                        .logoutSuccessUrl("/").permitAll()
                )
                // Disable CSRF because of "/logout":
                .csrf().disable()
                // Activates OAUTH2:
                .oauth2Login();
    }

}