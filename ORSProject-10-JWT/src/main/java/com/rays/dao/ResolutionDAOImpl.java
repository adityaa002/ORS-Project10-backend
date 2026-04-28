package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ResolutionDTO;

@Repository
public class ResolutionDAOImpl extends BaseDAOImpl<ResolutionDTO> implements ResolutionDAOInt{

	@Override
	public Class<ResolutionDTO> getDTOClass() {
 		return ResolutionDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(ResolutionDTO dto, CriteriaBuilder builder, Root<ResolutionDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isZeroNumber(dto.getId())) {

			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (!isEmptyString(dto.getIssue())) {
			whereCondition.add(builder.like(qRoot.get("issue"), dto.getIssue() + "%"));

		}
		return whereCondition;	 
	}

}
