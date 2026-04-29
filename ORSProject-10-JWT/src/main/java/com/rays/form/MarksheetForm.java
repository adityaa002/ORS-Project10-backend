package com.rays.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.MarksheetDTO;

/**
 * Form bean for capturing marksheet details from the UI layer.
 * <p>
 * Extends {@link BaseForm} to inherit common form properties such as
 * {@code id}, {@code createdBy}, {@code modifiedBy}, and pagination fields.
 * </p>
 *
 * <p>
 * This class applies validation annotations to ensure that required fields
 * are provided and marks are within valid ranges. It also provides a method
 * to convert form data into a {@link MarksheetDTO} for persistence.
 * </p>
 *
 * <p>
 * Typical usage includes capturing marksheet details during student result
 * entry and converting them into DTOs for service and DAO layers.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
public class MarksheetForm extends BaseForm {

    /** Unique roll number of the student. */
    @NotEmpty(message = "Roll No is required")
    protected String rollNo = null;

    /** Student ID associated with the marksheet. */
    @NotNull(message = "Student Name is required")
    @Min(1)
    protected Long studentId;

    /** Student name (optional, may be derived from studentId). */
    protected String name = null;

    /** Marks obtained in Physics (0–99). */
    @NotNull(message = "Physics is required")
    @Max(99)
    @Min(0)
    protected Integer physics;

    /** Marks obtained in Chemistry (0–99). */
    @NotNull(message = "Chemistry is required")
    @Max(99)
    @Min(0)
    protected Integer chemistry;

    /** Marks obtained in Mathematics (0–99). */
    @NotNull(message = "Maths is required")
    @Max(99)
    @Min(0)
    protected Integer maths;

    // -------------------------
    // Getters and Setters
    // -------------------------

    public String getRollNo() { return rollNo; }
    public void setRollNo(String rollNo) { this.rollNo = rollNo; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getPhysics() { return physics; }
    public void setPhysics(Integer physics) { this.physics = physics; }

    public Integer getChemistry() { return chemistry; }
    public void setChemistry(Integer chemistry) { this.chemistry = chemistry; }

    public Integer getMaths() { return maths; }
    public void setMaths(Integer maths) { this.maths = maths; }

    // -------------------------
    // BaseForm Override
    // -------------------------

    /**
     * Converts this form into a {@link MarksheetDTO}.
     *
     * @return a populated MarksheetDTO instance
     */
    @Override
    public BaseDTO getDto() {
        MarksheetDTO dto = initDTO(new MarksheetDTO());
        dto.setRollNo(rollNo);
        dto.setName(name);
        dto.setStudentId(studentId);
        dto.setPhysics(physics);
        dto.setChemistry(chemistry);
        dto.setMaths(maths);
        return dto;
    }
}
