package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.RoleDTO;

/**
 * Role Form
 *
 * <p>
 * This form is used to capture role-related input data from UI/API.
 * It validates incoming request data before converting it into {@link RoleDTO}.
 * </p>
 *
 * <p>
 * Used in user management module to define roles like ADMIN, USER, etc.
 * </p>
 *
 * <b>Fields:</b>
 * <ul>
 *   <li>name - role name</li>
 *   <li>description - role description</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
public class RoleForm extends BaseForm {

	/**
	 * Role name (e.g. ADMIN, USER)
	 */
	@NotEmpty(message = "Name is required")
	private String name;

	/**
	 * Role description
	 */
	@NotEmpty(message = "Description is required")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Converts Form data into RoleDTO.
	 *
	 * @return populated RoleDTO object
	 */
	@Override
	public BaseDTO getDto() {
		RoleDTO dto = initDTO(new RoleDTO());
		dto.setDescription(description);
		dto.setName(name);
		return dto;
	}
}