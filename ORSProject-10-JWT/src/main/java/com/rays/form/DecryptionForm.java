package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.DecryptionDTO;

/**
 * Decryption Form
 *
 * <p>
 * This form is used to capture decryption-related input data from UI/API.
 * It validates incoming request data before converting it into {@link DecryptionDTO}.
 * </p>
 *
 * <p>
 * Responsible for mapping request fields to DTO using {@link #getDto()} method.
 * </p>
 *
 * <b>Fields:</b>
 * <ul>
 *   <li>decryptionCode - unique decryption identifier/code</li>
 *   <li>algorithm - encryption/decryption algorithm used</li>
 *   <li>keyUsed - key used for decryption process</li>
 *   <li>status - current status of decryption record</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
public class DecryptionForm extends BaseForm {

	/**
	 * Unique decryption code
	 */
	@NotEmpty(message = "Decryption Code is required..!")
	private String decryptionCode;

	/**
	 * Algorithm used for decryption
	 */
	@NotEmpty(message = "Algorithm is required..!")
	private String algorithm;

	/**
	 * Key used in decryption process
	 */
	@NotEmpty(message = "KeyUsed is required..!")
	private String keyUsed;

	/**
	 * Status of decryption record
	 */
	@NotEmpty(message = "status is required..!")
	private String status;

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

	/**
	 * Converts Form data into DecryptionDTO.
	 *
	 * @return populated DecryptionDTO object
	 */
	@Override
	public BaseDTO getDto() {

		DecryptionDTO dto = initDTO(new DecryptionDTO());

		dto.setDecryptionCode(decryptionCode);
		dto.setAlgorithm(algorithm);
		dto.setKeyUsed(keyUsed);
		dto.setStatus(status);

		return dto;
	}
}