package com.rays.dto;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import com.rays.common.BaseDTO;

/**
 * Attachment Data Transfer Object
 *
 * <p>
 * Represents file attachment entity such as profile pictures or documents.
 * Stores file metadata and binary content in database.
 * </p>
 *
 * <p>
 * This entity maps to table <b>ST_ATTACHMENT</b>.
 * </p>
 *
 * <b>Fields:</b>
 * <ul>
 *   <li>name - file name</li>
 *   <li>type - MIME type of file</li>
 *   <li>description - file description</li>
 *   <li>userId - associated user</li>
 *   <li>doc - file content (stored as BLOB)</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
@Entity
@Table(name = "ST_ATTACHMENT")
public class AttachmentDTO extends BaseDTO {

	/**
	 * File name
	 */
	@Column(name = "NAME", length = 100)
	protected String name = null;

	/**
	 * File MIME type (e.g., image/png, application/pdf)
	 */
	@Column(name = "TYPE", length = 100)
	protected String type = null;

	/**
	 * Description of file
	 */
	@Column(name = "DESCRIPTION", length = 500)
	protected String description = null;

	/**
	 * Associated user ID
	 */
	@Column(name = "USER_ID")
	protected Long userId = null;

	/**
	 * File content stored as binary (BLOB)
	 */
	@Lob
	@Column(name = "DOC")
	private byte[] doc;

	/**
	 * Default constructor
	 */
	public AttachmentDTO() {
	}

	/**
	 * Constructs AttachmentDTO from MultipartFile.
	 *
	 * @param file uploaded file
	 */
	public AttachmentDTO(MultipartFile file) {
		name = file.getOriginalFilename();
		type = file.getContentType();

		try {
			doc = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getValue() {
		return null;
	}

	public byte[] getDoc() {
		return doc;
	}

	public void setDoc(byte[] doc) {
		this.doc = doc;
	}

	/**
	 * Returns unique key field (not implemented).
	 */
	@Override
	public String getUniqueKey() {
		return null;
	}

	/**
	 * Returns unique value (not implemented).
	 */
	@Override
	public String getUniqueValue() {
		return null;
	}

	/**
	 * Returns label for display (not implemented).
	 */
	@Override
	public String getLabel() {
		return null;
	}

	/**
	 * Returns table name (not implemented).
	 */
	@Override
	public String getTableName() {
		return null;
	}
}