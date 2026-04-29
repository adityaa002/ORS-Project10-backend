package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * Marksheet Data Transfer Object
 *
 * <p>
 * Represents student marksheet entity.
 * Stores academic details including roll number, student reference,
 * and subject-wise marks.
 * </p>
 *
 * <p>
 * This entity maps to table <b>st_marksheet</b>.
 * </p>
 *
 * <b>Fields:</b>
 * <ul>
 *   <li>rollNo - unique roll number of student</li>
 *   <li>studentId - reference to student</li>
 *   <li>name - student name</li>
 *   <li>physics - marks in Physics</li>
 *   <li>chemistry - marks in Chemistry</li>
 *   <li>maths - marks in Mathematics</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
@Entity
@Table(name = "st_marksheet")
public class MarksheetDTO extends BaseDTO {

	/**
	 * Roll number (unique)
	 */
	@Column(name = "roll_no", length = 20)
	protected String rollNo = null;

	/**
	 * Student ID (foreign key reference)
	 */
	@Column(name = "student_id")
	protected Long studentId;

	/**
	 * Student name
	 */
	@Column(name = "name", length = 50)
	protected String name = null;

	/**
	 * Physics marks
	 */
	@Column(name = "physics")
	protected Integer physics;

	/**
	 * Chemistry marks
	 */
	@Column(name = "chemistry")
	protected Integer chemistry;

	/**
	 * Mathematics marks
	 */
	@Column(name = "maths")
	protected Integer maths;

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhysics() {
		return physics;
	}

	public void setPhysics(Integer physics) {
		this.physics = physics;
	}

	public Integer getChemistry() {
		return chemistry;
	}

	public void setChemistry(Integer chemistry) {
		this.chemistry = chemistry;
	}

	public Integer getMaths() {
		return maths;
	}

	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	/**
	 * Returns unique key field.
	 */
	@Override
	public String getUniqueKey() {
		return "rollNo";
	}

	/**
	 * Returns unique value.
	 */
	@Override
	public String getUniqueValue() {
		return rollNo;
	}

	/**
	 * Returns label for UI display.
	 */
	@Override
	public String getLabel() {
		return "roll No";
	}

	/**
	 * Returns table name.
	 */
	@Override
	public String getTableName() {
		return "marksheet";
	}

	/**
	 * Returns value for dropdown/list.
	 */
	@Override
	public String getValue() {
		return name;
	}
}