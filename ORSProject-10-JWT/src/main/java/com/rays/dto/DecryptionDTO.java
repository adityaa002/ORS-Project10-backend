package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_decryption")
public class DecryptionDTO extends BaseDTO{

	@Column(name = "decryption_code", length = 50)
	private String decryptionCode;

	@Column(name = "algorithm", length = 50)
	private String algorithm;

	@Column(name = "key_used", length = 50)
	private String keyUsed;

	@Column(name = "status", length = 50)
	private String status;

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "decryptionCode";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return decryptionCode;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "Decryption";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Decryption";
	}

	public String getDecryptionCode() {
		return decryptionCode;
	}

	public void setDecryptionCode(String decryptionCode) {
		this.decryptionCode = decryptionCode;
	}

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	public String getKeyUsed() {
		return keyUsed;
	}

	public void setKeyUsed(String keyUsed) {
		this.keyUsed = keyUsed;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
