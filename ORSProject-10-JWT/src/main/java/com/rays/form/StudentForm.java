package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.StudentDTO;

/**
 * Student Form
 *
 * <p>
 * This form is used to capture student-related input data from UI/API.
 * It validates incoming request data before converting it into {@link StudentDTO}.
 * </p>
 *
 * <p>
 * Used in student management module for creating/updating student records.
 * </p>
 *
 * <b>Fields:</b>
 * <ul>
 *   <li>enrolNo - enrollment number</li>
 *   <li>firstName - first name of student</li>
 *   <li>lastName - last name of student</li>
 *   <li>dob - date of birth</li>
 *   <li>phoneNo - contact number</li>
 *   <li>email - email address</li>
 *   <li>collegeId / collegeName - associated college details</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
public class StudentForm extends BaseForm {

	/**
	 * Enrollment number of student
	 */
	@NotEmpty(message = "Enroll No is required")
	private String enrolNo;

	/**
	 * First name
	 */
	@NotEmpty(message = "First Name is required")
	private String firstName;

	/**
	 * Last name
	 */
	@NotEmpty(message = "Last Name is required")
	private String lastName;

	/**
	 * Date of birth
	 */
	@NotNull(message = "Date of birth is required")
	private Date dob;

	/**
	 * Phone number (10 digits)
	 */
	@NotNull(message = "Phone No is required")
	@Pattern(regexp = "[0-9]{10}", message = "Invalid phone number")
	private String phoneNo;

	/**
	 * Email address
	 */
	@NotEmpty(message = "Email ID is required")
	@Email
	private String email;

	/**
	 * College reference ID
	 */
	@NotNull(message = "College Name is required")
	@Min(1)
	private Long collegeId;

	private String collegeName;

	public String getEnrolNo() {
		return enrolNo;
	}

	public void setEnrolNo(String enrolNo) {
		this.enrolNo = enrolNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	/**
	 * Converts Form data into StudentDTO.
	 *
	 * @return populated StudentDTO object
	 */
	@Override
	public BaseDTO getDto() {

		StudentDTO dto = initDTO(new StudentDTO());

		dto.setEnrolNo(enrolNo);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setDob(dob);
		dto.setPhoneNo(phoneNo);
		dto.setEmail(email);
		dto.setCollegeId(collegeId);
		dto.setCollegeName(collegeName);

		return dto;
	}
}