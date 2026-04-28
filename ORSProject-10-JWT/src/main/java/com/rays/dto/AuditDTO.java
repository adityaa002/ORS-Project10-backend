package com.rays.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_audit")
public class AuditDTO extends BaseDTO {

	@Column(name = "audit_id", length = 50)
	private long auditId;

	@Column(name = "action_type", length = 50)
	private String actionType;

	@Column(name = "action_by", length = 50)
	private String actionBy;

	@Column(name = "action_time", length = 50)
	private LocalDateTime actionTime;

	@Column(name = "action_result", length = 50)
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

	public LocalDateTime getActionTime() {
		return actionTime;
	}

	public void setActionTime(LocalDateTime actionTime) {
		this.actionTime = actionTime;
	}

	public String getActionResult() {
		return actionResult;
	}

	public void setActionResult(String actionResult) {
		this.actionResult = actionResult;
	}

	@Override
	public String getUniqueKey() {
		return "actionType";
	}

	@Override
	public String getUniqueValue() {
		return actionType;
	}

	@Override
	public String getLabel() {
		return "Action";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Action";
	}

}
