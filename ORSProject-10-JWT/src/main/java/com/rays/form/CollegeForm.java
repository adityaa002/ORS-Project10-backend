package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CollegeDTO;

/**
 * College Form
 *
 * <p>
 * This form is used to capture college-related input data from UI/API.
 * It performs validation before converting data into {@link CollegeDTO}.
 * </p>
 *
 * <p>
 * Responsible for mapping request data into DTO using {@link #getDto()} method.
 * </p>
 *
 * <b>Fields:</b>
 * <ul>
 *   <li>name - college name</li>
 *   <li>address - college address</li>
 *   <li>state - state name</li>
 *   <li>city - city name</li>
 *   <li>phoneNo - contact number (10 digits)</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
public class CollegeForm extends BaseForm {

	/**
	 * College name
	 */
	@NotEmpty(message = "Name is required")
	private String name;

	/**
	 * College address
	 */
	@NotEmpty(message = "Address is required")
	private String address;

	/**
	 * State name
	 */
	@NotEmpty(message = "State is required")
	private String state;

	/**
	 * City name
	 */
	@NotEmpty(message = "City is required")
	private String city;

	/**
	 * Phone number (must be 10 digits)
	 */
	@NotNull(message = "Phone No is required")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phoneNo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * Converts form data into CollegeDTO.
	 *
	 * @return populated CollegeDTO object
	 */
	@Override
	public BaseDTO getDto() {
		CollegeDTO dto = initDTO(new CollegeDTO());

		dto.setName(name);
		dto.setAddress(address);
		dto.setState(state);
		dto.setCity(city);
		dto.setPhoneNo(phoneNo);

		return dto;
	}
}