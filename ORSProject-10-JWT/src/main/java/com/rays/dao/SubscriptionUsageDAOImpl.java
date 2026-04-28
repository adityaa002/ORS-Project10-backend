package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.SubscriptionUsageDTO;

@Repository
public class SubscriptionUsageDAOImpl extends BaseDAOImpl<SubscriptionUsageDTO> implements SubscriptionUsageDAOInt {

	@Override
	public Class<SubscriptionUsageDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return SubscriptionUsageDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(SubscriptionUsageDTO dto, CriteriaBuilder builder,
			Root<SubscriptionUsageDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isZeroNumber(dto.getId())) {
			
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}
		if (!isEmptyString(dto.getUsageCode())) {
			
			whereCondition.add(builder.like(qRoot.get("usageCode"), dto.getUsageCode() + "%"));
		}

		if (!isEmptyString(dto.getUserName())) {
			whereCondition.add(builder.like(qRoot.get("userName"), dto.getUserName() + "%"));
			
		}
		if (!isEmptyString(dto.getStatus())) {
			whereCondition.add(builder.equal(qRoot.get("status"), dto.getStatus()));
			
		}
		return whereCondition;
	}
}
