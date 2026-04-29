package com.rays.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * Data Transfer Object (DTO) representing audit records in the system.
 * <p>
 * Maps to the database table {@code st_audit} and stores information
 * about user actions, including type, actor, timestamp, and result.
 * </p>
 *
 * <p>
 * This class extends {@link BaseDTO}, inheriting common fields such as
 * {@code id}, {@code createdBy}, {@code modifiedBy}, and timestamps.
 * </p>
 *
 * <p>
 * Typical usage includes tracking CRUD operations, login attempts,
 * or other system events for auditing and compliance purposes.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
@Entity
@Table(name = "st_audit")
public class AuditDTO extends BaseDTO {

    /** Unique identifier for the audit record. */
    @Column(name = "audit_id", length = 50)
    private long auditId;

    /** Type of action performed (e.g., CREATE, UPDATE, DELETE, LOGIN). */
    @Column(name = "action_type", length = 50)
    private String actionType;

    /** User or system actor who performed the action. */
    @Column(name = "action_by", length = 50)
    private String actionBy;

    /** Timestamp when the action occurred. */
    @Column(name = "action_time", length = 50)
    private LocalDateTime actionTime;

    /** Result of the action (e.g., SUCCESS, FAILURE). */
    @Column(name = "action_result", length = 50)
    private String actionResult;

    // -------------------------
    // Getters and Setters
    // -------------------------

    public long getAuditId() {
        return auditId;
    }

    public void setAuditId(long auditId) {
        this.auditId = auditId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getActionBy() {
        return actionBy;
    }

    public void setActionBy(String actionBy) {
        this.actionBy = actionBy;
    }

    public LocalDateTime getActionTime() {
        return actionTime;
    }

    public void setActionTime(LocalDateTime actionTime) {
        this.actionTime = actionTime;
    }

    public String getActionResult() {
        return actionResult;
    }

    public void setActionResult(String actionResult) {
        this.actionResult = actionResult;
    }

    // -------------------------
    // BaseDTO Overrides
    // -------------------------

    @Override
    public String getUniqueKey() {
        return "actionType";
    }

    @Override
    public String getUniqueValue() {
        return actionType;
    }

    @Override
    public String getLabel() {
        return "Action";
    }

    @Override
    public String getTableName() {
        return "Action";
    }
}
