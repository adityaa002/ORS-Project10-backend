package com.rays.common;

import com.rays.dto.UserDTO;

/**
 * Holds contextual information about the currently logged-in user.
 * <p>
 * Provides details such as user ID, login ID, name, role, and associated
 * {@link UserDTO}. This context is used throughout the application to
 * maintain user-specific state and enforce role-based access.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
public class UserContext {

    /** Unique identifier of the user */
    private Long userId = 0L;

    /** Login ID (username/email) of the user */
    private String loginId = "root";

    /** Full name of the user */
    private String name = null;

    /** Role ID associated with the user */
    private Long roleId = 0L;

    /** Role name associated with the user */
    private String roleName = "root";

    /** Complete UserDTO object for additional user details */
    private UserDTO userDTO = null;

    /**
     * Default constructor.
     * <p>
     * Initializes context with default values.
     * </p>
     */
    public UserContext() {
    }

    /**
     * Constructs a UserContext from a UserDTO.
     *
     * @param dto UserDTO containing user details
     */
    public UserContext(UserDTO dto) {
        this.userDTO = dto;
        this.userId = dto.getId();
        this.loginId = dto.getLoginId();
        this.name = dto.getName();
        this.roleId = dto.getRoleId();
        this.roleName = dto.getRoleName();
    }

    // ---------------- Standard Getters and Setters ---------------- //

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
