package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * Data Transfer Object (DTO) representing student records in the system.
 * <p>
 * Maps to the database table {@code st_student} and stores information
 * about students, including enrollment number, personal details, contact
 * information, and associated college data.
 * </p>
 *
 * <p>
 * This class extends {@link BaseDTO}, inheriting common fields such as
 * {@code id}, {@code createdBy}, {@code modifiedBy}, and timestamps.
 * </p>
 *
 * <p>
 * Typical usage includes managing student records for admissions,
 * academic tracking, and administrative purposes.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
@Entity
@Table(name = "st_student")
public class StudentDTO extends BaseDTO {

    /** Unique enrollment number of the student. */
    @Column(name = "enrol_no", length = 20)
    private String enrolNo;

    /** First name of the student. */
    @Column(name = "first_name", length = 50)
    private String firstName;

    /** Last name of the student. */
    @Column(name = "last_name", length = 50)
    private String lastName;

    /** Date of birth of the student. */
    @Column(name = "dob")
    private Date dob;

    /** Contact phone number of the student. */
    @Column(name = "phone_no", length = 15)
    private String phoneNo;

    /** Email address of the student. */
    @Column(name = "email", length = 50)
    private String email;

    /** Associated college ID. */
    @Column(name = "college_id")
    private Long collegeId;

    /** Associated college name. */
    @Column(name = "college_name", length = 50)
    private String collegeName;

    // -------------------------
    // Getters and Setters
    // -------------------------

    public String getEnrolNo() { return enrolNo; }
    public void setEnrolNo(String enrolNo) { this.enrolNo = enrolNo; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }

    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Long getCollegeId() { return collegeId; }
    public void setCollegeId(Long collegeId) { this.collegeId = collegeId; }

    public String getCollegeName() { return collegeName; }
    public void setCollegeName(String collegeName) { this.collegeName = collegeName; }

    // -------------------------
    // BaseDTO Overrides
    // -------------------------

    @Override
    public String getUniqueKey() {
        return "enrolNo";
    }

    @Override
    public String getUniqueValue() {
        return enrolNo;
    }

    @Override
    public String getLabel() {
        return "Enroll No";
    }

    @Override
    public String getTableName() {
        return "Student";
    }

    @Override
    public String getValue() {
        return firstName;
    }
}
