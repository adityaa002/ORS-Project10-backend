package com.rays.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.SubjectDTO;

/**
 * Form bean for capturing subject details from the UI layer.
 * <p>
 * Extends {@link BaseForm} to inherit common form properties such as
 * {@code id}, {@code createdBy}, {@code modifiedBy}, and pagination fields.
 * </p>
 *
 * <p>
 * This class applies validation annotations to ensure that required fields
 * are provided and valid. It also provides a method to convert form data
 * into a {@link SubjectDTO} for persistence.
 * </p>
 *
 * <p>
 * Typical usage includes capturing subject details during course creation
 * or academic management workflows and converting them into DTOs for
 * service and DAO layers.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
public class SubjectForm extends BaseForm {

    /** Associated course ID (must be greater than 0). */
    @NotNull(message = "Course is required")
    @Min(1)
    private Long courseId = 0L;

    /** Name of the associated course. */
    private String courseName;

    /** Name of the subject. */
    @NotEmpty(message = "Name is required")
    private String name;

    /** Description of the subject. */
    @NotEmpty(message = "Description is required")
    private String description;

    // -------------------------
    // Getters and Setters
    // -------------------------

    public long getCourseId() { return courseId; }
    public void setCourseId(long courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    // -------------------------
    // BaseForm Override
    // -------------------------

    /**
     * Converts this form into a {@link SubjectDTO}.
     *
     * @return a populated SubjectDTO instance
     */
    @Override
    public BaseDTO getDto() {
        SubjectDTO dto = initDTO(new SubjectDTO());
        dto.setCourseId(courseId);
        dto.setCourseName(courseName);
        dto.setName(name);
        dto.setDescription(description);
        return dto;
    }
}
