package com.rays.ctl;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.common.UserContext;
import com.rays.config.JWTUtil;
import com.rays.dto.UserDTO;
import com.rays.form.LoginForm;
import com.rays.form.UserForm;
import com.rays.form.UserRegistrationForm;
import com.rays.service.UserServiceInt;

/**
 * Authentication Controller (Login / Signup / Forgot Password)
 *
 * <p>
 * Handles user authentication and authorization related APIs.
 * Provides endpoints for login, signup, forgot password, and logout.
 * </p>
 *
 * <b>Endpoints:</b>
 * <ul>
 *   <li>/Auth/login - Authenticate user and generate JWT token</li>
 *   <li>/Auth/signUp - Register new user</li>
 *   <li>/Auth/forgetPassword/{login} - Send password to registered email</li>
 *   <li>/Auth/logout - Logout user</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
@RestController
@RequestMapping(value = "Auth")
public class LoginCtl extends BaseCtl<UserForm, UserDTO, UserServiceInt> {
	
	/**
	 * Service layer for User operations
	 */
	@Autowired
	private UserServiceInt userService;

	/**
	 * Utility class for JWT generation and validation
	 */
	@Autowired
	private JWTUtil jwtUtil;
	
	/**
	 * Handles forgot password functionality.
	 *
	 * @param login   user login ID
	 * @param request HttpServletRequest
	 * @return ORSResponse with status message
	 */
	@GetMapping("forgetPassword/{login}")
	public ORSResponse forgotPassword(@PathVariable String login, HttpServletRequest request) {
		System.out.println("Forget password get run " + login);
		Enumeration<String> e = request.getHeaderNames();
		String key = null;
		while (e.hasMoreElements()) {
			key = e.nextElement();
			System.out.println(key + " = " + request.getHeader(key));
		}

		ORSResponse res = new ORSResponse(true);
		UserDTO dto = userService.forgotPassword(login);
		if (dto == null) {
			res.setSuccess(false);
			res.addMessage("Invalid Login Id");
		} else {
			res.setSuccess(true);
			res.addMessage("Password has been sent to email id");
		}
		return res;
	}

	/**
	 * Authenticates user and generates JWT token.
	 *
	 * @param form           login form containing credentials
	 * @param bindingResult  validation result
	 * @return ORSResponse containing user details and JWT token
	 * @throws Exception if token generation fails
	 */
	@PostMapping("login")
	public ORSResponse login(@RequestBody @Valid LoginForm form, BindingResult bindingResult) throws Exception {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		UserDTO dto = baseService.authenticate(form.getLoginId(), form.getPassword());

		if (dto == null) {
			res.setSuccess(false);
			res.addMessage("Invalid Login ID & Password");
		} else {

			UserContext context = new UserContext(dto);

			String token = jwtUtil.generateToken(dto.getId(), dto.getLoginId(), dto.getRoleName());

			res.setSuccess(true);
			res.addData(dto);
			res.addResult("loginId", dto.getLoginId());
			res.addResult("role", dto.getRoleName());
			res.addResult("fName", dto.getFirstName());
			res.addResult("lName", dto.getLastName());
			res.addResult("token", token);
			return res;
		}
		return res;
	}

	/**
	 * Registers a new user.
	 *
	 * @param form          registration form
	 * @param bindingResult validation result
	 * @return ORSResponse with registration status
	 */
	@PostMapping("signUp")
	public ORSResponse signUp(@RequestBody @Valid UserRegistrationForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		UserDTO dto = baseService.findByLoginId(form.getLoginId(), userContext);

		if (dto != null) {
			res.setSuccess(false);
			res.addMessage("Login Id already exists");
			return res;
		}

		dto = new UserDTO();
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLoginId(form.getLoginId());
		dto.setPassword(form.getPassword());
		dto.setDob(form.getDob());
		dto.setGender(form.getGender());
		dto.setPhone(form.getPhone());

		dto.setStatus("Inactive");
		dto.setRoleId(2L);

 		userService.register(dto);

		res.setSuccess(true);
		res.addData(dto.getId());
		res.addMessage("User has been registered successfully..!!");
		return res;
	}

	/**
	 * Handles logout functionality.
	 *
	 * @param session HttpSession
	 * @return ORSResponse with logout message
	 * @throws Exception if any error occurs
	 */
	@GetMapping("logout")
	public ORSResponse logout(HttpSession session) throws Exception {

		ORSResponse res = new ORSResponse();

		res.addMessage("Logout successfully..!!");

		return res;
	}
}