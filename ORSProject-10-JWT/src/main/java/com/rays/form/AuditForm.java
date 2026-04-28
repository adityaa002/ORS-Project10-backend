package com.rays.form;

import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.AuditDTO;

public class AuditForm extends BaseForm {

	@NotNull(message = "Audit Id is required")
	@Min(1)
	private long auditId;

	@NotEmpty(message = "Action Name is required")
	private String actionType;

	@NotEmpty(message = "Action By is required")
	private String actionBy;

	@NotNull(message = "Action time is required")
	private LocalDateTime actionTime;

	@NotEmpty(message = "Action Result is required")
	private String actionResult;

	public long getAuditId() {
		return auditId;
	}

	public void setAuditId(long auditId) {
		this.auditId = auditId;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getActionBy() {
		return actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public String getActionResult() {
		return actionResult;
	}

	public void setActionResult(String actionResult) {
		this.actionResult = actionResult;
	}

	@Override
	public BaseDTO getDto() {

		AuditDTO dto = initDTO(new AuditDTO());
		dto.setAuditId(auditId);
		dto.setActionType(actionType);
 		dto.setActionBy(actionBy);
		dto.setActionResult(actionResult);
		dto.setActionTime(actionTime);
		
		return dto;
		
	}

	public LocalDateTime getActionTime() {
		return actionTime;
	}

	public void setActionTime(LocalDateTime actionTime) {
		this.actionTime = actionTime;
	}

 

}
