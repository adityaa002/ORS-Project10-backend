package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * Data Transfer Object (DTO) representing blocked users in the system.
 * <p>
 * Maps to the database table {@code st_blockList} and stores information
 * about blocked accounts, including block code, username, reason, and status.
 * </p>
 *
 * <p>
 * This class extends {@link BaseDTO}, inheriting common fields such as
 * {@code id}, {@code createdBy}, {@code modifiedBy}, and timestamps.
 * </p>
 *
 * <p>
 * Typical usage includes maintaining a list of users who are restricted
 * from accessing certain features or the entire system due to violations,
 * security concerns, or administrative decisions.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
@Entity
@Table(name = "st_blockList")
public class BlockListDTO extends BaseDTO {

    /** Unique code identifying the block entry. */
    @Column(name = "block_code")
    private String blockCode;

    /** Username of the blocked user. */
    @Column(name = "user_name")
    private String userName;

    /** Reason for blocking the user. */
    @Column(name = "reason")
    private String reason;

    /** Current status of the block (e.g., ACTIVE, INACTIVE). */
    @Column(name = "status")
    private String status;

    // -------------------------
    // BaseDTO Overrides
    // -------------------------

    @Override
    public String getUniqueKey() {
        return "blockCode";
    }

    @Override
    public String getUniqueValue() {
        return blockCode;
    }

    @Override
    public String getLabel() {
        return "Block List";
    }

    @Override
    public String getTableName() {
        return "Block List";
    }

    // -------------------------
    // Getters and Setters
    // -------------------------

    public String getBlockCode() {
        return blockCode;
    }

    public void setBlockCode(String blockCode) {
        this.blockCode = blockCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
