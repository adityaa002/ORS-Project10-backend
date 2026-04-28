package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.RuleDTO;

@Repository
public class RuleDAOImpl extends BaseDAOImpl<RuleDTO> implements RuleDAOInt {

	@Override
	public Class<RuleDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return RuleDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(RuleDTO dto, CriteriaBuilder builder, Root<RuleDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isZeroNumber(dto.getId())) {

			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (!isEmptyString(dto.getRuleCode())) {
			whereCondition.add(builder.like(qRoot.get("ruleCode"), dto.getRuleCode() + "%"));

		}
		
		if (!isEmptyString(dto.getTriggerType())) {
			whereCondition.add(builder.like(qRoot.get("trigger"), dto.getTriggerType() + "%"));

		}
		return whereCondition;
	}

}
