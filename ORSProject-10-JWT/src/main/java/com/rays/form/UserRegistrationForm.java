package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Form bean for capturing user registration details from the UI layer.
 * <p>
 * This class applies validation annotations to ensure that required fields
 * are provided and valid. It is typically used during the user registration
 * workflow to collect personal and login information before converting it
 * into a DTO for persistence.
 * </p>
 *
 * <p>
 * Validation rules include:
 * <ul>
 *   <li>First name, last name, login ID, password, gender, and phone are mandatory.</li>
 *   <li>Login ID must be a valid email address.</li>
 *   <li>Date of birth must not be null.</li>
 *   <li>Phone number must be exactly 10 digits.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Typical usage includes capturing registration details from the frontend
 * and passing them to the service layer for account creation.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
public class UserRegistrationForm {

    /** First name of the user. */
    @NotEmpty(message = "First Name is required")
    private String firstName;

    /** Last name of the user. */
    @NotEmpty(message = "Last Name is required")
    private String lastName;

    /** Login ID (must be a valid email address). */
    @Email
    @NotEmpty(message = "Login Id is required")
    private String loginId;

    /** Password for the account. */
    @NotEmpty(message = "Password is required")
    private String password;

    /** Date of birth of the user. */
    @NotNull(message = "Date of birth is required")
    private Date dob;

    /** Gender of the user. */
    @NotEmpty(message = "Gender is required")
    private String gender;

    /** Mobile number (must be exactly 10 digits). */
    @NotEmpty(message = "Mobile No is required")
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String phone;

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

    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
