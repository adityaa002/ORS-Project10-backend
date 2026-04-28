package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_rule")
public class RuleDTO extends BaseDTO {

	@Column(name = "rule_id")
	private long ruleId;

	@Column(name = "rule_code")
	private String ruleCode;

	@Column(name = "event")
	private String event;

	@Column(name = "trigger_type")
	private String triggerType;

	@Column(name = "status")
	private String status;

	@Override
	public String getUniqueKey() {
		return "ruleCode";
	}

	@Override
	public String getUniqueValue() {
		return ruleCode;
	}

	@Override
	public String getLabel() {
		return "Rule";
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return ruleCode;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return triggerType;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Rule";
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
