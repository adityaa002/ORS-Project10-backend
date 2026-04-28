package com.rays.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.InquiryDTO;

public class InquiryForm extends BaseForm {

	@NotNull(message = "Inquiry id is required")
	@Min(1)
	private Long inquiryId;

	@NotEmpty(message = "Name is required")
	private String inquirerName;

	@Email(message = "Invalid email format")
	@NotEmpty(message = "Email is required")
	private String email;

	@NotEmpty(message = "Subject is required")
	private String inquirySubject;

	@NotEmpty(message = "Status is required")
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
	public BaseDTO getDto() {
		InquiryDTO dto = initDTO(new InquiryDTO());
		dto.setInquiryId(inquiryId);
		dto.setInquirerName(inquirerName);
		dto.setEmail(email);
		dto.setInquirySubject(inquirySubject);
		dto.setInquiryStatus(inquiryStatus);
		return dto;
	}
}
