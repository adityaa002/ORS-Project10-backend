package com.rays.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * Data Transfer Object (DTO) representing user accounts in the system.
 * <p>
 * Maps to the database table {@code st_user} and stores information
 * about users, including login credentials, personal details, role
 * assignments, and account status.
 * </p>
 *
 * <p>
 * This class extends {@link BaseDTO}, inheriting common fields such as
 * {@code id}, {@code createdBy}, {@code modifiedBy}, and timestamps.
 * </p>
 *
 * <p>
 * Typical usage includes authentication, authorization, and user
 * management within the application.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
@Entity
@Table(name = "st_user")
public class UserDTO extends BaseDTO {

    /** Constant representing active user status. */
    public static final String ACTIVE = "Active";

    /** Constant representing deactivated user status. */
    public static final String DEACTIVE = "Deactive";

    /** Constant representing locked user status. */
    public static final String LOCKED = "Locked";

    /** User's first name. */
    @Column(name = "first_name", length = 50)
    private String firstName;

    /** User's last name. */
    @Column(name = "last_name", length = 50)
    private String lastName;

    /** Unique login ID for authentication. */
    @Column(name = "login_id", length = 50)
    private String loginId;

    /** User's password. */
    @Column(name = "password", length = 50)
    private String password;

    /** Associated role ID. */
    @Column(name = "role_id")
    private Long roleId;

    /** Associated role name. */
    @Column(name = "role_name", length = 50)
    private String roleName = null;

    /** Date of birth of the user. */
    @Column(name = "dob")
    private Date dob;

    /** Gender of the user. */
    @Column(name = "gender", length = 10)
    private String gender;

    /** Primary phone number of the user. */
    @Column(name = "phone", length = 50)
    private String phone;

    /** Alternate mobile number of the user. */
    @Column(name = "alternate_mobile", length = 50)
    private String alternateMobile;

    /** Current account status (Active, Deactive, Locked). */
    @Column(name = "status", length = 20)
    private String status;

    /** Timestamp of the last login. */
    @Column(name = "last_login")
    private Timestamp lastLogin;

    /** Number of unsuccessful login attempts. */
    @Column(name = "unsucess_login")
    private Integer unsucessfullLoginAttempt = 0;

    /** Associated image ID for profile picture. */
    @Column(name = "image_id")
    private Long imageId;

    // -------------------------
    // Getters and Setters
    // -------------------------

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getLoginId() { return loginId; }
    public void setLoginId(String loginId) { this.loginId = loginId; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Long getRoleId() { return roleId; }
    public void setRoleId(Long roleId) { this.roleId = roleId; }

    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }

    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAlternateMobile() { return alternateMobile; }
    public void setAlternateMobile(String alternateMobile) { this.alternateMobile = alternateMobile; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Timestamp getLastLogin() { return lastLogin; }
    public void setLastLogin(Timestamp lastLogin) { this.lastLogin = lastLogin; }

    public Integer getUnsucessfullLoginAttempt() { return unsucessfullLoginAttempt; }
    public void setUnsucessfullLoginAttempt(Integer unsucessfullLoginAttempt) { this.unsucessfullLoginAttempt = unsucessfullLoginAttempt; }

    public Long getImageId() { return imageId; }
    public void setImageId(Long imageId) { this.imageId = imageId; }

    /** Returns full name by concatenating first and last names. */
    public String getName() { return firstName + " " + lastName; }

    // -------------------------
    // BaseDTO Overrides
    // -------------------------

    @Override
    public String getUniqueKey() {
        return "loginId";
    }

    @Override
    public String getUniqueValue() {
        return loginId;
    }

    @Override
    public String getLabel() {
        return "Login Id";
    }

    @Override
    public String getTableName() {
        return "User";
    }
}
