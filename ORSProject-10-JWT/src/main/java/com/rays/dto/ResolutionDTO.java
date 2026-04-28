package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_resolution")
public class ResolutionDTO extends BaseDTO {

	@Column(name = "resolution_id", length = 50)
	private long resolutionId;

	@Column(name = "resolution_code", length = 50)
	private String resolutionCode;

	@Column(name = "issue", length = 50)
	private String issue;

	@Column(name = "resolved_by", length = 50)
	private String resolvedBy;

	@Column(name = "status", length = 50)
	private String status;

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "issue";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return issue;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "Resolution Code";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Resolution";
	}

	public long getResolutionId() {
		return resolutionId;
	}

	public void setResolutionId(long resolutionId) {
		this.resolutionId = resolutionId;
	}

	public String getResolutionCode() {
		return resolutionCode;
	}

	public void setResolutionCode(String resolutionCode) {
		this.resolutionCode = resolutionCode;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getResolvedBy() {
		return resolvedBy;
	}

	public void setResolvedBy(String resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
