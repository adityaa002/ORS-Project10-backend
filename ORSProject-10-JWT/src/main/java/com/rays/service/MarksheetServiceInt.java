package com.rays.service;

import java.util.List;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.MarksheetDTO;
/**
 * Marksheet Service Interface
 *
 * <p>
 * Defines business service operations for Marksheet entity.
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
public interface MarksheetServiceInt extends BaseServiceInt<MarksheetDTO> {

	public MarksheetDTO findByName(String name, UserContext context);

	public MarksheetDTO findByRollNo(String rollNo, UserContext context);

	public List<MarksheetDTO> getMeritList(UserContext context);

}