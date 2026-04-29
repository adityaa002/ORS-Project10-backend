package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.TimeTableDAOInt;
import com.rays.dto.TimeTableDTO;
/**
 * TimeTable Service Implementation
 *
 * <p>
 * Provides business logic implementation for TimeTable entity.
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
public class TimeTableServiceImpl extends BaseServiceImpl<TimeTableDTO, TimeTableDAOInt>
		implements TimeTableServiceInt {

}