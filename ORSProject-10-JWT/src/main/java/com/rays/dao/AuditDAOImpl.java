package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.AuditDTO;

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
			builder.like(qRoot.get("actionType"), dto.getActionType());

		}
		if (!isZeroNumber(dto.getId())) {
			builder.like(qRoot.get("id"), dto.getId() + "%");

		}

		return whereCondition;
	}

}
