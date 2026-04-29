package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CourseDTO;

/**
 * Course Form
 *
 * <p>
 * This form is used to capture course-related input data from UI/API.
 * It validates incoming request data before converting it into {@link CourseDTO}.
 * </p>
 *
 * <p>
 * Responsible for mapping request fields to DTO using {@link #getDto()} method.
 * </p>
 *
 * <b>Fields:</b>
 * <ul>
 *   <li>name - course name</li>
 *   <li>duration - course duration</li>
 *   <li>description - course description</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
public class CourseForm extends BaseForm {

	/**
	 * Course name
	 */
	@NotEmpty(message = "Name is required")
	private String name;

	/**
	 * Course duration
	 */
	@NotEmpty(message = "Duration is required")
	private String duration;

	/**
	 * Course description
	 */
	@NotEmpty(message = "Description is required")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Converts Form data into CourseDTO.
	 *
	 * @return populated CourseDTO object
	 */
	@Override
	public BaseDTO getDto() {

		CourseDTO dto = initDTO(new CourseDTO());
		dto.setName(name);
		dto.setDuration(duration);
		dto.setDescription(description);

		return dto;
	}
}