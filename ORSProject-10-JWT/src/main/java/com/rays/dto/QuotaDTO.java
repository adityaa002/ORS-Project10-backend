package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_quota")
public class QuotaDTO extends BaseDTO {

	@Column(name = "quota_code", length = 50)
	private String quotaCode;

	@Column(name = "user_name", length = 50)
	private String userName;

	@Column(name = "limit_value", length = 50)
	private int limitValue;

	@Column(name = "status", length = 50)
	private String status;

	@Override
	public String getUniqueKey() {
		return "userName";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "Quota";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Quota";
	}

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

}
