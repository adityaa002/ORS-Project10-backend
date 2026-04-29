package com.rays.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.filter.OncePerRequestFilter;

import com.rays.common.UserContext;
import com.rays.common.UserContextHolder;
import com.rays.dto.UserDTO;
import com.rays.service.JWTUserDetailsService;

/**
 * JWT Request Filter for handling authentication and authorization.
 * <p>
 * This filter intercepts every incoming HTTP request, extracts the JWT token
 * from the Authorization header, validates it, and sets the authentication
 * in Spring Security context. It also stores user-specific information
 * in ThreadLocal using {@link UserContextHolder}.
 * </p>
 *
 * <p>
 * If token validation fails, the request is rejected with HTTP 401 (Unauthorized).
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
@Component
public class JWTRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private JWTUserDetailsService jwtUserDetailsService;

	/**
	 * Extracts and validates the JWT from the {@code Authorization: Bearer} header.
	 * On success, sets the authentication in {@link SecurityContextHolder} and
	 * stores the {@link UserContext} in thread-local storage. On failure, responds
	 * with {@code 401 UNAUTHORIZED}.
	 *
	 * @param request     the incoming HTTP request
	 * @param response    the outgoing HTTP response
	 * @param filterChain the filter chain to continue if authentication succeeds
	 * @throws ServletException if a servlet error occurs
	 * @throws IOException      if an I/O error occurs while writing the error
	 *                          response
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String authorizationHeader = request.getHeader("Authorization");		

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			
			String jwtToken = authorizationHeader.substring(7);

			try {

				String loginId = jwtUtil.extractLoginId(jwtToken);

				if (!jwtUtil.validateToken(jwtToken, loginId)) {
					throw new Exception("Invalid JWT token");
				}

				 if (loginId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	                    
	                    String role = jwtUtil.extractRole(jwtToken);
	                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
	                            loginId, null,
	                            List.of(new SimpleGrantedAuthority("ROLE_" + role))
	                    );
	                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
	                }

				UserDTO dto = new UserDTO();
				dto.setLoginId(loginId);

				UserContext context = new UserContext(dto);

				// ThreadLocal me set
				UserContextHolder.setContext(context);

			} catch (Exception e) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.getWriter().write(e.getMessage());
				return;
			}
		}
		filterChain.doFilter(request, response);
	}
}