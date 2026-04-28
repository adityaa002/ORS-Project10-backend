package com.rays.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.SettingDTO;

public class SettingForm extends BaseForm {

	@NotNull(message = "Inquiry id is required")
	@Min(1)
	private long settingId;

	@NotEmpty(message = "Setting Name is required")
	private String settingName;

	@NotEmpty(message = "Setting Value is required")
	private String settingValue;

	@NotEmpty(message = "Setting Type is required")
	private String settingType;

	@NotEmpty(message = "Setting Status is required")
	private String settingStatus;

	public long getSettingId() {
		return settingId;
	}

	public void setSettingId(long settingId) {
		this.settingId = settingId;
	}

	public String getSettingName() {
		return settingName;
	}

	public void setSettingName(String settingName) {
		this.settingName = settingName;
	}

	public String getSettingValue() {
		return settingValue;
	}

	public void setSettingValue(String settingValue) {
		this.settingValue = settingValue;
	}

	public String getSettingType() {
		return settingType;
	}

	public void setSettingType(String settingType) {
		this.settingType = settingType;
	}

	public String getSettingStatus() {
		return settingStatus;
	}

	public void setSettingStatus(String settingStatus) {
		this.settingStatus = settingStatus;
	}

	@Override
	public BaseDTO getDto() {
		SettingDTO dto = initDTO(new SettingDTO());
		dto.setSettingId(settingId);
		dto.setSettingName(settingName);
		dto.setSettingValue(settingValue);
		dto.setSettingType(settingType);
		dto.setSettingStatus(settingStatus);

		return dto;
	}
}
