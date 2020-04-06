package hofls.com.github.rest.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomUserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/people/**").hasRole("MODERATOR")
				.antMatchers(HttpMethod.DELETE, "/people/**").hasRole("ADMIN")
				.and()
			.formLogin()
				.loginProcessingUrl("/auth/login")
				.successHandler((request, response, authentication) -> {})
				.failureHandler((request, response, exception) -> {
					response.setStatus(HttpStatus.UNAUTHORIZED.value());
				})
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/auth/logout")
				.logoutSuccessHandler((request, response, authentication) -> {
				})
				.permitAll()
				.and()
			.exceptionHandling()
				.authenticationEntryPoint((request, response, authException) -> {
					response.setStatus(HttpStatus.FORBIDDEN.value());
				})
				.and()
			.csrf().disable();
	}

}
