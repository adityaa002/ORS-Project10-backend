
package com.rays.dao;

import java.util.List;

import com.rays.common.BaseDAOInt;
import com.rays.dto.MarksheetDTO;
/**
 * Marksheet DAO Interface
 *
 * <p>
 * Defines data access operations for Marksheet entity.
 * Extends {@link BaseDAOInt} to inherit generic CRUD operations.
 * </p>
 *
 * <p>
 * Additional custom queries (if required) can be declared here.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
public interface MarksheetDAOInt extends BaseDAOInt<MarksheetDTO> {
	public List<MarksheetDTO> getMeritList();
}
