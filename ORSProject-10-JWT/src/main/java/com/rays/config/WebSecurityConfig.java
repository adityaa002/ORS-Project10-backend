package com.rays.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Spring Security Configuration class for configuring authentication
 * and authorization rules for the application.
 *
 * <p>
 * This configuration:
 * <ul>
 *   <li>Disables CSRF protection (suitable for stateless APIs)</li>
 *   <li>Allows unauthenticated access to specific endpoints</li>
 *   <li>Secures all other endpoints</li>
 *   <li>Configures stateless session management (JWT आधारित)</li>
 *   <li>Adds JWT filter before default authentication filter</li>
 * </ul>
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Custom JWT filter for request validation
	 */
	@Autowired
	private JWTRequestFilter jwtRequestFilter;

	/**
	 * Configures HTTP security including authorization rules,
	 * session management, and filter chain.
	 *
	 * @param http HttpSecurity object
	 * @throws Exception in case of configuration errors
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
			.antMatchers("/auth/**", "/Auth/**", "/User/profilePic/**", "/Jasper/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		http.cors();
	}
}