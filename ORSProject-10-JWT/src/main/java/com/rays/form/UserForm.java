package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.UserDTO;

/**
 * User Form
 *
 * <p>
 * This form is used to capture user-related input data from UI/API.
 * It validates incoming request data before converting it into {@link UserDTO}.
 * </p>
 *
 * <p>
 * Used in authentication and user management module for registration,
 * login, and profile handling.
 * </p>
 *
 * <b>Fields:</b>
 * <ul>
 *   <li>firstName / lastName - user identity</li>
 *   <li>loginId - unique login identifier (email/username)</li>
 *   <li>password - user password</li>
 *   <li>roleId / roleName - role mapping</li>
 *   <li>dob - date of birth</li>
 *   <li>gender - gender</li>
 *   <li>phone - primary mobile number</li>
 *   <li>alternateMobile - secondary contact</li>
 *   <li>status - active/inactive state</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
public class UserForm extends BaseForm {

	/**
	 * First name of user
	 */
	@NotEmpty(message = "First Name is required")
	private String firstName;

	/**
	 * Last name of user
	 */
	@NotEmpty(message = "Last Name is required")
	private String lastName;

	/**
	 * Login ID (unique username/email)
	 */
	@NotEmpty(message = "Login Id is required")
	private String loginId;

	/**
	 * Password (should be encrypted in service layer)
	 */
	@NotEmpty(message = "Password is required")
	private String password;

	/**
	 * Role reference ID
	 */
	@NotNull(message = "Role is required")
	@Min(1)
	private Long roleId;

	private String roleName = null;

	/**
	 * Date of birth
	 */
	@NotNull(message = "Date of birth is required")
	private Date dob;

	/**
	 * Gender
	 */
	@NotEmpty(message = "Gender is required")
	private String gender;

	/**
	 * Primary phone number (10 digits)
	 */
	@NotNull(message = "Mobile No is required")
	@Pattern(regexp = "[0-9]{10}", message = "Invalid mobile number")
	private String phone;

	/**
	 * Alternate mobile number
	 */
	@NotEmpty(message = "Alternate Mobile No is required")
	private String alternateMobile;

	/**
	 * User status (ACTIVE / INACTIVE)
	 */
	@NotEmpty(message = "Status is required")
	private String status;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAlternateMobile() {
		return alternateMobile;
	}

	public void setAlternateMobile(String alternateMobile) {
		this.alternateMobile = alternateMobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Converts Form data into UserDTO.
	 *
	 * @return populated UserDTO object
	 */
	@Override
	public BaseDTO getDto() {

		UserDTO dto = initDTO(new UserDTO());
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setLoginId(loginId);
		dto.setPassword(password);
		dto.setRoleId(roleId);
		dto.setRoleName(roleName);
		dto.setDob(dob);
		dto.setGender(gender);
		dto.setPhone(phone);
		dto.setAlternateMobile(alternateMobile);
		dto.setStatus(status);

		return dto;
	}
}