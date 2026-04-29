package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * TimeTable Data Transfer Object
 *
 * <p>
 * Represents exam timetable entity.
 * Stores details about course, subject, exam date, time, and semester.
 * </p>
 *
 * <p>
 * This entity maps to table <b>st_timetable</b>.
 * </p>
 *
 * <b>Fields:</b>
 * <ul>
 *   <li>courseId - reference to course</li>
 *   <li>courseName - course name</li>
 *   <li>subjectId - reference to subject</li>
 *   <li>subjectName - subject name</li>
 *   <li>examDate - exam date</li>
 *   <li>examTime - exam time</li>
 *   <li>semester - semester info</li>
 *   <li>description - additional details</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
@Entity
@Table(name = "st_timetable")
public class TimeTableDTO extends BaseDTO {

	/**
	 * Course ID (foreign key)
	 */
	@Column(name = "course_id", length = 50)
	private long courseId;

	/**
	 * Course name
	 */
	@Column(name = "course_name", length = 50)
	private String courseName;

	/**
	 * Subject ID (foreign key)
	 */
	@Column(name = "subject_id", length = 50)
	private long subjectId;

	/**
	 * Subject name
	 */
	@Column(name = "subject_name", length = 50)
	private String subjectName;

	/**
	 * Exam date
	 */
	@Column(name = "exam_date")
	private Date examDate;

	/**
	 * Exam time
	 */
	@Column(name = "exam_time", length = 50)
	private String examTime;

	/**
	 * Semester information
	 */
	@Column(name = "semester", length = 30)
	private String semester;

	/**
	 * Additional description
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

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
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
		return "courseName";
	}

	/**
	 * Returns unique value.
	 */
	@Override
	public String getUniqueValue() {
		return courseName;
	}

	/**
	 * Returns label for UI (not implemented).
	 */
	@Override
	public String getLabel() {
		return null;
	}

	/**
	 * Returns table name.
	 */
	@Override
	public String getTableName() {
		return "TimeTable";
	}

	/**
	 * Returns value for dropdown/list (not implemented).
	 */
	@Override
	public String getValue() {
		return null;
	}
}