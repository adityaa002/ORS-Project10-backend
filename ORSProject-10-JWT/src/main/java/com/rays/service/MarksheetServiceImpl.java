package com.rays.service;

import java.util.List;

 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.MarksheetDAOInt;
import com.rays.dto.MarksheetDTO;

/**
 * Marksheet Service Implementation
 *
 * <p>
 * Provides business logic implementation for Marksheet entity.
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
public class MarksheetServiceImpl extends BaseServiceImpl<MarksheetDTO, MarksheetDAOInt>
		implements MarksheetServiceInt {

	@Transactional(readOnly = true)
	public MarksheetDTO findByName(String name, UserContext context) {
		return baseDao.findByUniqueKey("name", name, context);
	}

	@Override
	public MarksheetDTO findByRollNo(String rollNo, UserContext context) {
		return baseDao.findByUniqueKey("rollNo", rollNo, context);
	}

	@Override
	public List<MarksheetDTO> getMeritList(UserContext context) {
		System.out.println("GetMarksheetMeitList (MarksheetService)");
		return baseDao.getMeritList();
	}

}