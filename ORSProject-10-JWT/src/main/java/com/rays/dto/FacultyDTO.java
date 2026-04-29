package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * Data Transfer Object (DTO) representing faculty members in the system.
 * <p>
 * Maps to the database table {@code st_faculty} and stores information
 * about faculty members, including personal details, contact information,
 * qualifications, and associated college, course, and subject data.
 * </p>
 *
 * <p>
 * This class extends {@link BaseDTO}, inheriting common fields such as
 * {@code id}, {@code createdBy}, {@code modifiedBy}, and timestamps.
 * </p>
 *
 * <p>
 * Typical usage includes managing faculty records for academic institutions,
 * course allocations, and subject assignments.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
@Entity
@Table(name = "st_faculty")
public class FacultyDTO extends BaseDTO {

    /** Faculty member's first name. */
    @Column(name = "first_name", length = 50)
    private String firstName;

    /** Faculty member's last name. */
    @Column(name = "last_name", length = 50)
    private String lastName;

    /** Date of birth of the faculty member. */
    @Column(name = "dob")
    private Date dob;

    /** Gender of the faculty member. */
    @Column(name = "gender", length = 10)
    private String gender;

    /** Contact phone number of the faculty member. */
    @Column(name = "phone_no", length = 15)
    private String phoneNo;

    /** Email address of the faculty member (unique identifier). */
    @Column(name = "email", length = 50)
    private String email;

    /** Academic qualification of the faculty member. */
    @Column(name = "qualification", length = 15)
    private String qualification;

    /** Associated college ID. */
    @Column(name = "college_id", length = 50)
    private long collegeId;

    /** Associated college name. */
    @Column(name = "college_name", length = 50)
    private String collegeName;

    /** Associated course ID. */
    @Column(name = "course_id", length = 50)
    private long courseId;

    /** Associated course name. */
    @Column(name = "course_name", length = 50)
    private String courseName;

    /** Associated subject ID. */
    @Column(name = "subject_id", length = 50)
    private long subjectId;

    /** Associated subject name. */
    @Column(name = "subject_name", length = 50)
    private String subjectName;

    // -------------------------
    // Getters and Setters
    // -------------------------

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getQualification() { return qualification; }
    public void setQualification(String qualification) { this.qualification = qualification; }

    public long getCollegeId() { return collegeId; }
    public void setCollegeId(long collegeId) { this.collegeId = collegeId; }

    public String getCollegeName() { return collegeName; }
    public void setCollegeName(String collegeName) { this.collegeName = collegeName; }

    public long getCourseId() { return courseId; }
    public void setCourseId(long courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public long getSubjectId() { return subjectId; }
    public void setSubjectId(long subjectId) { this.subjectId = subjectId; }

    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }

    // -------------------------
    // BaseDTO Overrides
    // -------------------------

    @Override
    public String getUniqueKey() {
        return "email";
    }

    @Override
    public String getUniqueValue() {
        return email;
    }

    @Override
    public String getLabel() {
        return "Email";
    }

    @Override
    public String getTableName() {
        return "Faculty";
    }

    @Override
    public String getValue() {
        return null; // Can be customized if needed
    }
}
