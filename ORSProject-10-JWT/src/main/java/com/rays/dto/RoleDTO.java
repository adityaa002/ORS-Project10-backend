package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * Data Transfer Object (DTO) representing a role entity in the system.
 * <p>
 * Maps to the database table {@code st_role} and stores information
 * about roles, including their name and description.
 * </p>
 *
 * <p>
 * This class extends {@link BaseDTO}, inheriting common fields such as
 * {@code id}, {@code createdBy}, {@code modifiedBy}, and timestamps.
 * </p>
 *
 * <p>
 * Typical usage includes managing user roles for authorization and
 * access control within the application.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
@Entity
@Table(name = "st_role")
public class RoleDTO extends BaseDTO {

    /** Name of the role (unique identifier). */
    @Column(name = "name", length = 50)
    private String name = null;

    /** Description of the role. */
    @Column(name = "description", length = 100)
    private String description = null;

    // -------------------------
    // Getters and Setters
    // -------------------------

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    // -------------------------
    // BaseDTO Overrides
    // -------------------------

    @Override
    public String getUniqueKey() {
        return "name";
    }

    @Override
    public String getUniqueValue() {
        return name;
    }

    @Override
    public String getLabel() {
        return "Role Name";
    }

    @Override
    public String getTableName() {
        return "Role";
    }

    @Override
    public String getValue() {
        return name;
    }
}
