package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.TimeTableDTO;

/**
 * TimeTable Form
 *
 * <p>
 * This form is used to capture timetable-related input data from UI/API.
 * It validates incoming request data before converting it into {@link TimeTableDTO}.
 * </p>
 *
 * <p>
 * Used in examination module to schedule exams for courses and subjects.
 * </p>
 *
 * <b>Fields:</b>
 * <ul>
 *   <li>courseId / courseName - course details</li>
 *   <li>subjectId / subjectName - subject details</li>
 *   <li>examDate - date of exam</li>
 *   <li>examTime - time of exam</li>
 *   <li>semester - semester information</li>
 *   <li>description - additional details</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
public class TimeTableForm extends BaseForm {

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

	/**
	 * Exam date
	 */
	@NotNull(message = "Exam Date is required")
	private Date examDate;

	/**
	 * Exam time slot
	 */
	@NotEmpty(message = "Exam Time is required")
	private String examTime;

	/**
	 * Semester
	 */
	@NotEmpty(message = "Semester is required")
	private String semester;

	/**
	 * Additional description
	 */
	@NotEmpty(message = "Description is required")
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
	 * Converts Form data into TimeTableDTO.
	 *
	 * @return populated TimeTableDTO object
	 */
	@Override
	public BaseDTO getDto() {

		TimeTableDTO dto = initDTO(new TimeTableDTO());
		dto.setCourseId(courseId);
		dto.setCourseName(courseName);
		dto.setSubjectId(subjectId);
		dto.setSubjectName(subjectName);
		dto.setExamDate(examDate);
		dto.setExamTime(examTime);
		dto.setSemester(semester);
		dto.setDescription(description);

		return dto;
	}
}