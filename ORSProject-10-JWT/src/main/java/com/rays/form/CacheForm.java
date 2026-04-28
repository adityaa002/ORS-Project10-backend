package com.rays.form;

  import javax.validation.constraints.NotEmpty;
 
import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CacheDTO;

public class CacheForm extends BaseForm {

	

	@NotEmpty(message = "Cache Code is required..!")
	private String cacheCode;

	@NotEmpty(message = "keyName is required..!")
	private String keyName;

	@NotEmpty(message = "value is required..!")
	private String value;

	@NotEmpty(message = "status is required..!")
	private String status;

	 

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public BaseDTO getDto() {

		CacheDTO dto = initDTO(new CacheDTO());

 		dto.setCacheCode(cacheCode);
		dto.setKeyName(keyName);
		dto.setValue(value);
		dto.setStatus(status);
		
		return dto;
	}

}
