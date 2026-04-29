package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * Cache Data Transfer Object
 *
 * <p>
 * Represents cache configuration stored in database.
 * Used for storing key-value based dynamic configurations.
 * </p>
 *
 * <p>
 * This entity maps to table <b>st_cache</b>.
 * </p>
 *
 * <b>Fields:</b>
 * <ul>
 *   <li>cacheId - unique identifier for cache</li>
 *   <li>cacheCode - unique cache code</li>
 *   <li>keyName - key name for cache entry</li>
 *   <li>value - value associated with key</li>
 *   <li>status - active/inactive status</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
@Entity
@Table(name = "st_cache")
public class CacheDTO extends BaseDTO {

	/**
	 * Cache ID
	 */
	@Column(name = "cache_id", length = 50)
	private Long cacheId;

	/**
	 * Unique cache code
	 */
	@Column(name = "cache_code", length = 50)
	private String cacheCode;

	/**
	 * Key name for cache
	 */
	@Column(name = "key_name", length = 50)
	private String keyName;

	/**
	 * Value associated with key
	 */
	@Column(name = "value", length = 50)
	private String value;

	/**
	 * Status of cache (Active/Inactive)
	 */
	@Column(name = "status", length = 50)
	private String status;

	/**
	 * Returns unique key field name.
	 */
	@Override
	public String getUniqueKey() {
		return "cacheCode";
	}

	/**
	 * Returns unique value.
	 */
	@Override
	public String getUniqueValue() {
		return cacheCode;
	}

	/**
	 * Returns label for UI display.
	 */
	@Override
	public String getLabel() {
		return "Cache Code";
	}

	/**
	 * Returns table name.
	 */
	@Override
	public String getTableName() {
		return "Cache";
	}
	
	/**
	 * Returns key for dropdown/list.
	 */
	@Override
	public String getKey() {
		return id + "";
	}
	
	/**
	 * Returns value for dropdown/list.
	 */
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