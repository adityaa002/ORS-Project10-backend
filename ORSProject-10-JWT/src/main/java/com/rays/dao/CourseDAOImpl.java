package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CourseDTO;
/**
 * Course Data Access Object Implementation
 *
 * <p>
 * Provides database interaction logic for Course entity.
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
public class CourseDAOImpl extends BaseDAOImpl<CourseDTO> implements CourseDAOInt {

	@Override
	public Class<CourseDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return CourseDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(CourseDTO dto, CriteriaBuilder builder, Root<CourseDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		return whereCondition;
	}

}