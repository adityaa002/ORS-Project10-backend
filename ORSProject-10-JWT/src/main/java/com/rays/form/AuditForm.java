package com.rays.form;

import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.AuditDTO;

/**
 * Audit Form
 *
 * <p>
 * This form is used to capture audit-related input data from UI/API.
 * It performs validation before converting data into {@link AuditDTO}.
 * </p>
 *
 * <p>
 * Responsible for mapping request data to DTO using {@link #getDto()} method.
 * </p>
 *
 * <b>Fields:</b>
 * <ul>
 *   <li>auditId - unique audit identifier</li>
 *   <li>actionType - type of action performed</li>
 *   <li>actionBy - user who performed action</li>
 *   <li>actionTime - timestamp of action</li>
 *   <li>actionResult - result of action</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
public class AuditForm extends BaseForm {

	/**
	 * Audit ID (must be >= 1)
	 */
	@NotNull(message = "Audit Id is required")
	@Min(1)
	private long auditId;

	/**
	 * Type of action performed
	 */
	@NotEmpty(message = "Action Name is required")
	private String actionType;

	/**
	 * User who performed the action
	 */
	@NotEmpty(message = "Action By is required")
	private String actionBy;

	/**
	 * Time of action execution
	 */
	@NotNull(message = "Action time is required")
	private LocalDateTime actionTime;

	/**
	 * Result of the action
	 */
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

	/**
	 * Converts Form data into AuditDTO.
	 *
	 * @return populated AuditDTO object
	 */
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