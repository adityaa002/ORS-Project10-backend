package com.rays.common;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * Abstract base Data Transfer Object (DTO).
 * <p>
 * Provides common fields such as ID, audit information (created/modified by, timestamps),
 * and enforces contract methods for unique key, label, and table name.
 * All entity DTOs should extend this class to inherit standard fields.
 * </p>
 *
 * Implements {@link DropdownList} to support dropdown UI components.
 *
 * @author Aditya
 * @version 1.0
 */
@MappedSuperclass
public abstract class BaseDTO implements DropdownList {

    @Id
    @GeneratedValue(generator = "ncsPk")
    @GenericGenerator(name = "ncsPk", strategy = "native")
    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    @Column(name = "created_by", length = 50)
    protected String createdBy = "root";

    @Column(name = "modified_by", length = 50)
    protected String modifiedBy = "root";

    @Column(name = "created_datetime")
    protected Timestamp createdDatetime;

    @Column(name = "modified_datetime")
    protected Timestamp modifiedDatetime;

    /**
     * Returns the unique key field name for the DTO.
     *
     * @return unique key attribute name
     */
    public abstract String getUniqueKey();

    /**
     * Returns the unique value for the DTO.
     *
     * @return unique value
     */
    public abstract String getUniqueValue();

    /**
     * Returns a human-readable label for the DTO.
     *
     * @return label string
     */
    public abstract String getLabel();

    /**
     * Returns the database table name associated with the DTO.
     *
     * @return table name
     */
    public abstract String getTableName();

    // ---------------- Standard Getters and Setters ---------------- //

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Timestamp getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(Timestamp createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public Timestamp getModifiedDatetime() {
        return modifiedDatetime;
    }

    public void setModifiedDatetime(Timestamp modifiedDatetime) {
        this.modifiedDatetime = modifiedDatetime;
    }

    // ---------------- DropdownList Implementation ---------------- //

    /**
     * Returns the primary key as a string for dropdown usage.
     *
     * @return string representation of ID
     */
    @Override
    public String getKey() {
        return id + "";
    }

    /**
     * Returns the display value for dropdown usage.
     * <p>
     * By default, returns null. Subclasses should override this method
     * to provide meaningful display values.
     * </p>
     *
     * @return dropdown display value
     */
    @Override
    public String getValue() {
        return null;
    }
}
