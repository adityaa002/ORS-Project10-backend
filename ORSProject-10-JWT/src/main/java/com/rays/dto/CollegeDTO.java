package com.rays.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * Data Transfer Object (DTO) representing a college entity in the system.
 * <p>
 * Maps to the database table {@code st_college} and stores information
 * about a college, including its name, state, address, city, and phone number.
 * </p>
 *
 * <p>
 * This class extends {@link BaseDTO}, inheriting common fields such as
 * {@code id}, {@code createdBy}, {@code modifiedBy}, and timestamps.
 * </p>
 *
 * <p>
 * Typical usage includes managing college records for student admissions,
 * course allocations, and administrative purposes.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
@Entity
@Table(name = "st_college")
public class CollegeDTO extends BaseDTO {

    /** Name of the college. */
    private String name;

    /** State where the college is located. */
    private String state;

    /** Address of the college. */
    private String address;

    /** City where the college is located. */
    private String city;

    /** Contact phone number of the college. */
    private String phoneNo;

    // -------------------------
    // Getters and Setters
    // -------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

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
        return "College name";
    }

    @Override
    public String getTableName() {
        return name;
    }

    @Override
    public String getKey() {
        return id + "";
    }

    @Override
    public String getValue() {
        return city;
    }
}
