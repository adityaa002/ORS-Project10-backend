package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.BlockListDAOInt;
import com.rays.dto.BlockListDTO;

/**
 * BlockList Service Implementation
 *
 * <p>
 * Provides business logic implementation for BlockList entity.
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
public class BlockListServiceImpl extends BaseServiceImpl<BlockListDTO, BlockListDAOInt>
		implements BlockListServiceInt {

}
