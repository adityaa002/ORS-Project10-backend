package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ResolutionDTO;

public class ResolutionForm extends BaseForm {
 	@NotNull(message  = "Resolution Id is required")
	private long resolutionId;

	@NotEmpty(message = "Resolution Code is required")
	private String resolutionCode;

	@NotEmpty(message = "Issue is required")
	private String issue;

	@NotEmpty(message = "ResolvedBy is required")
	private String resolvedBy;

	@NotEmpty(message = "Status is required")
	private String status;

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

	@Override
	public BaseDTO getDto() {

		ResolutionDTO dto = initDTO(new ResolutionDTO());

		dto.setResolutionId(resolutionId);
		dto.setResolutionCode(resolutionCode);
		dto.setIssue(issue);
		dto.setResolvedBy(resolvedBy);
		dto.setStatus(status);

		return dto;
	}

}
