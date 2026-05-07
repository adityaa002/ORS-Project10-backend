package com.rays.form;
 
import javax.validation.constraints.NotEmpty;
 

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.PasswordDTO;

public class PasswordForm extends BaseForm {
 
	@NotEmpty(message = "passwordCode is required.!")
	private String passwordCode;

	@NotEmpty(message = "userName is required.!")
	private String userName;

	@NotEmpty(message = "passwordValue is required.!")
	private String passwordValue;

	@NotEmpty(message = "status is required.!")
	private String status;

	public String getPasswordCode() {
		return passwordCode;
	}

	public void setPasswordCode(String passwordCode) {
		this.passwordCode = passwordCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswordValue() {
		return passwordValue;
	}

	public void setPasswordValue(String passwordValue) {
		this.passwordValue = passwordValue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public BaseDTO getDto() {

		PasswordDTO dto = initDTO(new PasswordDTO());
 		dto.setPasswordCode(passwordCode);
		dto.setUserName(userName);
		dto.setPasswordValue(passwordValue);
		dto.setStatus(status);

		return dto;
	}

 
}
