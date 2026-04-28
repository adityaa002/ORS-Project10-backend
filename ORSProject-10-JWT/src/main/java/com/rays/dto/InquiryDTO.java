package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_inquiry")
public class InquiryDTO extends BaseDTO {

	@Column(name = "inquiry_id")
	private Long inquiryId;

	@Column(name = "inquiry_name")
	private String inquirerName;

	@Column(name = "email")
	private String email;

	@Column(name = "inquiry_subject")
	private String inquirySubject;

	@Column(name = "inquiry_status")
	private String inquiryStatus;

	public Long getInquiryId() {
		return inquiryId;
	}

	public void setInquiryId(Long inquiryId) {
		this.inquiryId = inquiryId;
	}

	public String getInquirerName() {
		return inquirerName;
	}

	public void setInquirerName(String inquirerName) {
		this.inquirerName = inquirerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInquirySubject() {
		return inquirySubject;
	}

	public void setInquirySubject(String inquirySubject) {
		this.inquirySubject = inquirySubject;
	}

	public String getInquiryStatus() {
		return inquiryStatus;
	}

	public void setInquiryStatus(String inquiryStatus) {
		this.inquiryStatus = inquiryStatus;
	}

	@Override
	public String getUniqueKey() {
		return "email";
	}

	@Override
	public String getUniqueValue() {
		return email;
	}

	@Override
	public String getLabel() {
		return "Email id";
	}

	@Override
	public String getTableName() {
		return "Inquiry";
	}

}
