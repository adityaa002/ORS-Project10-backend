package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rays.dto.UserDTO;

/**
 * JWT User Details Service
 *
 * <p>
 * Custom implementation of {@link UserDetailsService} used by Spring Security
 * to authenticate users during login.
 * </p>
 *
 * <p>
 * This service fetches user details from database and converts them into
 * Spring Security compatible {@link UserDetails} object.
 * </p>
 *
 * <b>Responsibilities:</b>
 * <ul>
 *   <li>Load user by username (loginId)</li>
 *   <li>Validate user existence</li>
 *   <li>Provide user credentials and roles to Spring Security</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
@Service
public class JWTUserDetailsService implements UserDetailsService {

	/**
	 * Password encoder bean using BCrypt hashing algorithm.
	 *
	 * @return PasswordEncoder instance
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	UserServiceInt userService;

	/**
	 * Loads user details by username (loginId).
	 *
	 * <p>
	 * Fetches user from database and converts into {@link UserDetails}.
	 * Throws exception if user not found.
	 * </p>
	 *
	 * @param username loginId of user
	 * @return UserDetails object for authentication
	 * @throws UsernameNotFoundException if user does not exist
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDTO user = userService.findByLoginId(username, null);

		if (user == null) {
			System.out.println("user found nuulllll");
			throw new UsernameNotFoundException("User not found with username : " + username);
		}

		return User.builder()
				.username(user.getLoginId())
				.password(passwordEncoder().encode(user.getPassword()))
				.roles("USER")
				.build();
	}
}