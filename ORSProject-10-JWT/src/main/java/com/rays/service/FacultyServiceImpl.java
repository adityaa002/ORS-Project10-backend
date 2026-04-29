package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.FacultyDAOInt;
import com.rays.dto.FacultyDTO;

/**
 * Faculty Service Implementation
 *
 * <p>
 * Provides business logic implementation for Faculty entity.
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
public class FacultyServiceImpl extends BaseServiceImpl<FacultyDTO, FacultyDAOInt> implements FacultyServiceInt {

}