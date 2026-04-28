package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.SettingDTO;

@Repository
public class SettingDAOImpl extends BaseDAOImpl<SettingDTO> implements SettingDAOInt{

	@Override 
	public Class<SettingDTO> getDTOClass() {
		return SettingDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(SettingDTO dto, CriteriaBuilder builder, Root<SettingDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isZeroNumber(dto.getSettingId())) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}
		if (!isEmptyString(dto.getSettingName())) {
			whereCondition.add(builder.like(qRoot.get("name"), dto.getSettingName()));
		}

		return whereCondition;
	}

}
