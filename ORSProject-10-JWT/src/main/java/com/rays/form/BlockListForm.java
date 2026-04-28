package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.BlockListDTO;

public class BlockListForm extends BaseForm {

 	
	@NotEmpty(message = "blockCode is required")
	private String blockCode;

	@NotEmpty(message = "userName is required")
	private String userName;

	@NotEmpty(message = "reason is required")
	private String reason;

	@NotEmpty(message = "status is required")
	private String status;

	public String getBlockCode() {
		return blockCode;
	}

	public void setBlockCode(String blockCode) {
		this.blockCode = blockCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public BaseDTO getDto() {

		BlockListDTO dto =	 initDTO(new BlockListDTO());
		
 		dto.setUserName(userName);
		dto.setBlockCode(blockCode);
		dto.setReason(reason);
		dto.setStatus(status);
		
		return dto;
	}

}
