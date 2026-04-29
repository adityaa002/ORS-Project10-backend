package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.FacultyDTO;

/**
 * Faculty Form
 *
 * <p>
 * This form is used to capture faculty-related input data from UI/API.
 * It performs validation before converting request data into {@link FacultyDTO}.
 * </p>
 *
 * <p>
 * Responsible for mapping form fields to DTO using {@link #getDto()} method.
 * </p>
 *
 * <b>Fields:</b>
 * <ul>
 *   <li>firstName - faculty first name</li>
 *   <li>lastName - faculty last name</li>
 *   <li>dob - date of birth</li>
 *   <li>gender - gender</li>
 *   <li>phoneNo - contact number</li>
 *   <li>email - email address</li>
 *   <li>qualification - highest qualification</li>
 *   <li>collegeId / collegeName - college details</li>
 *   <li>courseId / courseName - course details</li>
 *   <li>subjectId / subjectName - subject details</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
public class FacultyForm extends BaseForm {

	/**
	 * First name of faculty
	 */
	@NotEmpty(message = "First Name is required")
	private String firstName;

	/**
	 * Last name of faculty
	 */
	@NotEmpty(message = "Last Name is required")
	private String lastName;

	/**
	 * Date of birth
	 */
	@NotNull(message = "Date of birth is required")
	private Date dob;

	/**
	 * Gender
	 */
	@NotEmpty(message = "Gender is required")
	private String gender;

	/**
	 * Phone number (10 digits)
	 */
	@NotNull(message = "Phone No is required")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phoneNo;

	/**
	 * Email address
	 */
	@NotEmpty(message = "Email ID is required")
	private String email;

	/**
	 * Qualification
	 */
	@NotEmpty(message = "Qualification is required")
	private String qualification;

	/**
	 * College reference ID
	 */
	@NotNull(message = "College is required")
	@Min(1)
	private Long collegeId = 0L;

	private String collegeName;

	/**
	 * Course reference ID
	 */
	@NotNull(message = "Course is required")
	@Min(1)
	private Long courseId = 0L;

	private String courseName;

	/**
	 * Subject reference ID
	 */
	@NotNull(message = "Subject is required")
	@Min(1)
	private Long subjectId = 0L;

	private String subjectName;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	/**
	 * Converts Form data into FacultyDTO.
	 *
	 * @return populated FacultyDTO object
	 */
	@Override
	public BaseDTO getDto() {

		FacultyDTO dto = initDTO(new FacultyDTO());
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setDob(dob);
		dto.setGender(gender);
		dto.setPhoneNo(phoneNo);
		dto.setEmail(email);
		dto.setQualification(qualification);
		dto.setCollegeId(collegeId);
		dto.setCollegeName(collegeName);
		dto.setCourseId(courseId);
		dto.setCourseName(courseName);
		dto.setSubjectId(subjectId);
		dto.setSubjectName(subjectName);

		return dto;
	}
}