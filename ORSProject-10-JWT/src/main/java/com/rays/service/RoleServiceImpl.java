package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.RoleDAOInt;
import com.rays.dto.RoleDTO;

/**
 * Role Service Implementation
 *
 * <p>
 * Provides business logic implementation for Role entity.
 * Extends {@link BaseServiceImpl} to inherit generic CRUD operations.
 * </p>
 *
 * <p>
 * This layer acts as an intermediary between Controller and DAO.
 * Additional business rules (if required) can be implemented here.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<RoleDTO, RoleDAOInt> implements RoleServiceInt {

	@Override
	@Transactional(readOnly = true)
	public RoleDTO findByName(String name, UserContext userContext) {

		return baseDao.findByUniqueKey(name, name, userContext);
	}

}