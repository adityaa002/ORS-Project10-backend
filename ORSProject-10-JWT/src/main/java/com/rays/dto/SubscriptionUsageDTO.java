package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_subscription_usage")
public class SubscriptionUsageDTO extends BaseDTO {

	 
	@Column(name = "usage_code", length = 50)
	private String usageCode;

	@Column(name = "user_name", length = 50)
	private String userName;

	@Column(name = "usage_count", length = 50)
	private long usageCount;

	@Column(name = "status", length = 50)
	private String status;

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "usageCode";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return usageCode;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "Subscription";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Subscription";
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

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return usageCode;
	}

}
