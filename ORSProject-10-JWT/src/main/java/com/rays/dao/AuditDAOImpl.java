package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.AuditDTO;

/**
 * Audit Data Access Object Implementation
 *
 * <p>
 * Provides database interaction logic for Audit entity. Extends
 * {@link BaseDAOImpl} to inherit generic CRUD operations.
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
public class AuditDAOImpl extends BaseDAOImpl<AuditDTO> implements AuditDAOInt {

	@Override
	public Class<AuditDTO> getDTOClass() {
		return AuditDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(AuditDTO dto, CriteriaBuilder builder, Root<AuditDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getActionType())) {
			whereCondition.add(builder.like(qRoot.get("actionType"), dto.getActionType()));

		}
		if (!isZeroNumber(dto.getId())) {
			whereCondition.add(builder.like(qRoot.get("id"), dto.getId() + "%"));

		}

		return whereCondition;
	}

}
