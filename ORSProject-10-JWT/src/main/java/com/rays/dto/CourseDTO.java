package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * Course Data Transfer Object
 *
 * <p>
 * Represents course entity in the system.
 * Stores details such as course name, duration, and description.
 * </p>
 *
 * <p>
 * This entity maps to table <b>st_course</b>.
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
@Entity
@Table(name = "st_course")
public class CourseDTO extends BaseDTO {

	/**
	 * Course name
	 */
	@Column(name = "name", length = 50)
	private String name;

	/**
	 * Course duration (e.g., 3 months, 1 year)
	 */
	@Column(name = "duration", length = 50)
	private String duration;

	/**
	 * Course description
	 */
	@Column(name = "description", length = 50)
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
	 * Returns unique key field.
	 */
	@Override
	public String getUniqueKey() {
		return "name";
	}

	/**
	 * Returns unique value.
	 */
	@Override
	public String getUniqueValue() {
		return name;
	}

	/**
	 * Returns label for UI display.
	 */
	@Override
	public String getLabel() {
		return "Course Name";
	}

	/**
	 * Returns table name.
	 */
	@Override
	public String getTableName() {
		return "Course";
	}

	/**
	 * Returns value for dropdown/list.
	 */
	@Override
	public String getValue() {
		return name;
	}
}