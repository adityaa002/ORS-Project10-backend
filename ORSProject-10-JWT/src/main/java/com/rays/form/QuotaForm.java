package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.QuotaDTO;

public class QuotaForm extends BaseForm {

	@NotEmpty(message = "Quota Code is required..!")
	private String quotaCode;

	@NotEmpty(message = "UserName is required..!")
	private String userName;

	@NotNull(message = "Limit Value is required..!")
	private int limitValue;

	@NotEmpty(message = "Status is required..!")
	private String status;

	public String getQuotaCode() {
		return quotaCode;
	}

	public void setQuotaCode(String quotaCode) {
		this.quotaCode = quotaCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getLimitValue() {
		return limitValue;
	}

	public void setLimitValue(int limitValue) {
		this.limitValue = limitValue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public BaseDTO getDto() {
		QuotaDTO dto = initDTO(new QuotaDTO());
		dto.setUserName(userName);
		dto.setQuotaCode(quotaCode);
		dto.setStatus(status);
		dto.setLimitValue(limitValue);
		
		return dto;
	}
}
