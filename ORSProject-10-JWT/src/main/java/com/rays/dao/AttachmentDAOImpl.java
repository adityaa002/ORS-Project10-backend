package com.rays.dao;
 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.AttachmentDTO;

/**
 * Attachment Data Access Object Implementation
 *
 * <p>
 * Provides database interaction logic for Attachment entity.
 * Extends {@link BaseDAOImpl} to inherit generic CRUD operations.
 * </p>
 *
 * <p>
 * Uses JPA Criteria API for dynamic query construction.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
@Repository
public class AttachmentDAOImpl extends BaseDAOImpl<AttachmentDTO> implements AttachmentDAOInt {

	@Override
	public Class<AttachmentDTO> getDTOClass() {
		return AttachmentDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(AttachmentDTO dto, CriteriaBuilder builder, Root<AttachmentDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();
		return whereCondition;
	}

}
