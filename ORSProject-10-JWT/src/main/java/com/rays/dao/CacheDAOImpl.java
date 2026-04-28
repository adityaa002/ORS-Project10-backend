package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CacheDTO;

@Repository
public class CacheDAOImpl extends BaseDAOImpl<CacheDTO> implements CacheDAOInt{

	@Override
	public Class<CacheDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return CacheDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(CacheDTO dto, CriteriaBuilder builder, Root<CacheDTO> qRoot) {

	    List<Predicate> whereCondition = new ArrayList<>();
	    
	    if (!isZeroNumber(dto.getId())) {
	        whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
	    }
	    

	    if (!isZeroNumber(dto.getCacheId())) {
	        whereCondition.add(builder.equal(qRoot.get("cacheId"), dto.getCacheId()));
	    }

	    if (!isEmptyString(dto.getStatus())) {
	        whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus() + "%"));
	    }

	    if (!isEmptyString(dto.getCacheCode())) {
	        whereCondition.add(builder.equal(qRoot.get("cacheCode"), dto.getCacheCode()));
	    }

	    if (!isEmptyString(dto.getKeyName())) {
	        whereCondition.add(builder.like(qRoot.get("keyName"), dto.getKeyName() + "%"));
	    }

	    return whereCondition;
	}

}
