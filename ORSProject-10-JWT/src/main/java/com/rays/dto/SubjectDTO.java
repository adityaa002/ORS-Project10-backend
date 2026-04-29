package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * Subject Data Transfer Object
 *
 * <p>
 * Represents subject entity in the system.
 * Each subject is associated with a course and contains
 * details like subject name and description.
 * </p>
 *
 * <p>
 * This entity maps to table <b>st_subject</b>.
 * </p>
 *
 * <b>Fields:</b>
 * <ul>
 *   <li>courseId - reference to course</li>
 *   <li>courseName - name of associated course</li>
 *   <li>name - subject name</li>
 *   <li>description - subject description</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
@Entity
@Table(name = "st_subject")
public class SubjectDTO extends BaseDTO {

	/**
	 * Course ID (foreign key reference)
	 */
	@Column(name = "course_id", length = 50)
	private long courseId;

	/**
	 * Course name
	 */
	@Column(name = "course_name", length = 50)
	private String courseName;

	/**
	 * Subject name
	 */
	@Column(name = "name", length = 50)
	private String name;

	/**
	 * Subject description
	 */
	@Column(name = "description", length = 50)
	private String description;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Subject Name";
	}

	/**
	 * Returns table name.
	 */
	@Override
	public String getTableName() {
		return "Subject";
	}

	/**
	 * Returns value for dropdown/list.
	 */
	@Override
	public String getValue() {
		return courseName;
	}
}