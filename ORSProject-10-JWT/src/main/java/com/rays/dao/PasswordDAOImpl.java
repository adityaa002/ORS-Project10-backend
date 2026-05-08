package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.PasswordDTO;

@Repository
public class PasswordDAOImpl extends BaseDAOImpl<PasswordDTO> implements PasswordDAOInt {

	@Override
	public Class<PasswordDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return PasswordDTO.class;
	}

	@Override  
	protected List<Predicate> getWhereClause(PasswordDTO dto, CriteriaBuilder builder, Root<PasswordDTO> qRoot) {
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
		if (!isEmptyString(dto.getPasswordCode())) {
			whereCondition.add(builder.like(qRoot.get("passwordCode"), dto.getPasswordCode() + "%"));

		}
		return whereCondition;
	}

}
