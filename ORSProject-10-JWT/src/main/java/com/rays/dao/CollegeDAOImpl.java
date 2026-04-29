package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CollegeDTO;
/**
 * College Data Access Object Implementation
 *
 * <p>
 * Provides database interaction logic for College entity.
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
public class CollegeDAOImpl extends BaseDAOImpl<CollegeDTO> implements CollegeDAOInt {

	@Override
	public Class<CollegeDTO> getDTOClass() {
		return CollegeDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(CollegeDTO dto, CriteriaBuilder builder, Root<CollegeDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();
		if (!isEmptyString(dto.getName())) {

			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}

		if (!isEmptyString(dto.getCity())) {

			whereCondition.add(builder.like(qRoot.get("city"), dto.getCity() + "%"));
		}

		if (!isEmptyString(dto.getState())) {

			whereCondition.add(builder.like(qRoot.get("state"), dto.getState() + "%"));
		}

		if (!isEmptyString(dto.getAddress())) {

			whereCondition.add(builder.like(qRoot.get("address"), dto.getAddress() + "%"));
		}

		if (!isEmptyString(dto.getPhoneNo())) {

			whereCondition.add(builder.like(qRoot.get("phoneNo"), dto.getPhoneNo() + "%"));
		}

		return whereCondition;
	}

}