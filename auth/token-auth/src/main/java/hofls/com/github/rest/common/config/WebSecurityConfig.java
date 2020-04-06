package hofls.com.github.rest.common.config;

import hofls.com.github.rest.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	TokenService tokenService;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception
	{
		PreAuthTokenHeaderFilter filter = new PreAuthTokenHeaderFilter("AUTH_API_KEY");

		filter.setAuthenticationManager(new AuthenticationManager() {
			@Override
			public Authentication authenticate(Authentication authentication)
					throws AuthenticationException {
				String token = (String) authentication.getPrincipal();

				List<GrantedAuthority> authorities = tokenService.getTokens().get(token);
				if (CollectionUtils.isEmpty(authorities)) {
					throw new BadCredentialsException("The API key was not found ");
				}
				authentication.setAuthenticated(true);
				return authentication;
			}
		});

		httpSecurity.
				antMatcher("/people/**")
					.csrf().disable()
					.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
					.and()
				.addFilter(filter)
				.addFilterBefore(
						new ExceptionTranslationFilter(new Http403ForbiddenEntryPoint()), filter.getClass()
				)
				.authorizeRequests()
				.anyRequest()
				.authenticated();
	}

}

