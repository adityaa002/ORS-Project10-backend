package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.UserDTO;
/**
 * User Service Interface
 *
 * <p>
 * Defines business service operations for User entity.
 * Extends {@link BaseServiceInt} to inherit generic service methods
 * like add, update, delete, search, and find operations.
 * </p>
 *
 * <p>
 * Additional business-specific methods (if required) can be declared here.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
public interface UserServiceInt extends BaseServiceInt<UserDTO> {

	public UserDTO findByLoginId(String name, UserContext userContext);
 
	public UserDTO authenticate(String loginId, String password);
	
	public boolean changePassword(String loginId, String oldPassword, String newPassword, UserContext userContext);

	public UserDTO forgotPassword(String loginId);

	public long register(UserDTO dto);

}