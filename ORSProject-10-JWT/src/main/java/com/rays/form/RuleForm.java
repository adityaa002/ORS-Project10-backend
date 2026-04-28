package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.RuleDTO;

public class RuleForm extends BaseForm {

	@NotNull(message = "rule_id is required")
	private long ruleId;

	@NotEmpty(message = "ruleCode is required")
	private String ruleCode;

	@NotEmpty(message = "event is required")
	private String event;

	@NotEmpty(message = "triggerType is required")
	private String triggerType;

	@NotEmpty(message = "status is required")
	private String status;

	@Override
	public BaseDTO getDto() {
		RuleDTO dto =  initDTO(new RuleDTO());
		
		dto.setRuleId(ruleId);
		dto.setRuleCode(ruleCode);
		dto.setEvent(event);
		dto.setTriggerType(triggerType);
		dto.setStatus(status);
		
		return dto;
 	}

	public long getRuleId() {
		return ruleId;
	}

	public void setRuleId(long ruleId) {
		this.ruleId = ruleId;
	}

	public String getRuleCode() {
		return ruleCode;
	}

	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getTriggerType() {
		return triggerType;
	}

	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
