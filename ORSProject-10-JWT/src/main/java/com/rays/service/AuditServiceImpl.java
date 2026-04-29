package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.AuditDAOInt;
import com.rays.dto.AuditDTO;

/**
 * Audit Service Implementation
 *
 * <p>
 * Provides business logic implementation for Audit entity.
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
public class AuditServiceImpl extends BaseServiceImpl<AuditDTO, AuditDAOInt> implements AuditServiceInt {

}
