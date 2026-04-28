package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.DecryptionDTO;

@Repository
public class DecryptionDAOImpl extends BaseDAOImpl<DecryptionDTO> implements DecryptionDAOInt{

	@Override
	public Class<DecryptionDTO> getDTOClass() {
 		return DecryptionDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(DecryptionDTO dto, CriteriaBuilder builder, Root<DecryptionDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isZeroNumber(dto.getId())) {

			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (!isEmptyString(dto.getAlgorithm())) {
			whereCondition.add(builder.like(qRoot.get("algorithm"), dto.getAlgorithm() + "%"));

		}
		return whereCondition;
	}
}
