package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.QuotaDTO;

@Repository
public class QuotaDAOImpl extends BaseDAOImpl<QuotaDTO> implements QuotaDAOInt {

	@Override
	public Class<QuotaDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return QuotaDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(QuotaDTO dto, CriteriaBuilder builder, Root<QuotaDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isZeroNumber(dto.getId())) {

			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (!isEmptyString(dto.getUserName())) {
			whereCondition.add(builder.like(qRoot.get("userName"), dto.getUserName() + "%"));

		}
		if (!isEmptyString(dto.getStatus())) {
			whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus() + "%"));

		}

		return whereCondition;
	}

}
