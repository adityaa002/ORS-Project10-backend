package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_cache")
public class CacheDTO extends BaseDTO {

	@Column(name = "cache_id", length = 50)
	private Long cacheId;

	@Column(name = "cache_code", length = 50)
	private String cacheCode;

	@Column(name = "key_name", length = 50)
	private String keyName;

	@Column(name = "value", length = 50)
	private String value;

	@Column(name = "status", length = 50)
	private String status;

	@Override
	public String getUniqueKey() {
		 
		return "cacheCode";
	}

	@Override
	public String getUniqueValue() {
		 
		return cacheCode;
	}

	@Override
	public String getLabel() {
 		return "Cache Code";
	}

	@Override
	public String getTableName() {
 		return "Cache";
	}
	
	@Override
	public String getKey() {
		 
		return id+"";
	}
	
	@Override
	public String getValue() {
		 
		return cacheCode;
	}

	public Long getCacheId() {
		return cacheId;
	}

	public void setCacheId(Long cacheId) {
		this.cacheId = cacheId;
	}

	public String getCacheCode() {
		return cacheCode;
	}

	public void setCacheCode(String cacheCode) {
		this.cacheCode = cacheCode;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
