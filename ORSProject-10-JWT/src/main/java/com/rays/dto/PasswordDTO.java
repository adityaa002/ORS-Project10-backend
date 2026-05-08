package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_password")
public class PasswordDTO extends BaseDTO {

	@Column(name = "password_code", length = 50)
	private String passwordCode; 

	@Column(name = "user_name", length = 50)
	private String userName;

	@Column(name = "password_value", length = 50)
	private String passwordValue;

	@Column(name = "status", length = 50)
	private String status;

	@Override
	public String getUniqueKey() {

		return "passwordCode";
	}

	@Override
	public String getUniqueValue() {

		return passwordCode;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "passwordCode" ;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Password";
	}

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
	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		return userName;
	}

}
