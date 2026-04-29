package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.RoleDTO;
/**
 * Role Service Interface
 *
 * <p>
 * Defines business service operations for Role entity.
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
public interface RoleServiceInt extends BaseServiceInt<RoleDTO> {

	public RoleDTO findByName(String name, UserContext userContext);
}