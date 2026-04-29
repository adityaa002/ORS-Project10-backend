package com.rays.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Login Form
 *
 * <p>
 * This form is used to capture login credentials from user.
 * It validates input data before authentication process in service layer.
 * </p>
 *
 * <p>
 * Used in authentication API to verify user identity.
 * </p>
 *
 * <b>Fields:</b>
 * <ul>
 *   <li>loginId - registered email used as username</li>
 *   <li>password - user password</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
public class LoginForm {

	/**
	 * User login ID (email format)
	 */
	@NotEmpty(message = "Login Id is required")
	@Email
	private String loginId;

	/**
	 * User password
	 */
	@NotEmpty(message = "Password is required")
	private String password;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}