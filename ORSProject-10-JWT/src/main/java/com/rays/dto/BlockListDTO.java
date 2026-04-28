package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_blockList")
public class BlockListDTO extends BaseDTO {

	@Column(name = "block_code")
	private String blockCode;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "reason")
	private String reason;
	
	@Column(name = "status")
	private String status;

	@Override
	public String getUniqueKey() {
		return "blockCode";
	}

	@Override
	public String getUniqueValue() {
		return blockCode;
	}

	@Override
	public String getLabel() {
		return "Block List";
	}

	@Override
	public String getTableName() {
		return "Block List";
	}

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

}
