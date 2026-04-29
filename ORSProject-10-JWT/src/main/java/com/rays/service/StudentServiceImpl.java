package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.StudentDAOInt;
import com.rays.dto.StudentDTO;

/**
 * Student Service Implementation
 *
 * <p>
 * Provides business logic implementation for Student entity.
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
public class StudentServiceImpl extends BaseServiceImpl<StudentDTO, StudentDAOInt> implements StudentServiceInt {

}