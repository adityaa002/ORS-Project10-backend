package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.CacheDAOInt;
import com.rays.dto.CacheDTO;

/**
 * Cache Service Implementation
 *
 * <p>
 * Provides business logic implementation for Cache entity.
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
public class CacheServiceImpl extends BaseServiceImpl<CacheDTO, CacheDAOInt> implements CacheServiceInt{

}
