package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.SubscriptionUsageDTO;

public class SubscriptionUsageForm extends BaseForm {
 

	@NotEmpty(message = "usageCode is required..!")
	private String usageCode;

	@NotEmpty(message = "userName is required..!")
	private String userName;

	@NotNull(message = "usageCount is required..!")
	private long usageCount;

	@NotEmpty(message = "status is required..!")
	private String status;

	@Override
	public BaseDTO getDto() {

		SubscriptionUsageDTO dto = initDTO(new SubscriptionUsageDTO());
		
		dto.setUsageCode(usageCode);
		dto.setUsageCount(usageCount);
		dto.setUserName(userName);
 		dto.setStatus(status);
		
		return dto;

	}
 

	public String getUsageCode() {
		return usageCode;
	}

	public void setUsageCode(String usageCode) {
		this.usageCode = usageCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

 

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getUsageCount() {
		return usageCount;
	}

	public void setUsageCount(long usageCount) {
		this.usageCount = usageCount;
	}

	 

}
