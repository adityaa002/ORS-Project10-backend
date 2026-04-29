package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.PrescriptionDTO;

/**
 * Prescription Form
 *
 * <p>
 * This form is used to capture prescription-related input data from UI/API.
 * It validates incoming request data before converting it into {@link PrescriptionDTO}.
 * </p>
 *
 * <p>
 * Used in medical module to store prescription details like patient, doctor, and date.
 * </p>
 *
 * <b>Fields:</b>
 * <ul>
 *   <li>prescriptionId - unique prescription identifier</li>
 *   <li>patientName - name of patient</li>
 *   <li>doctorName - name of doctor</li>
 *   <li>prescribedDate - date of prescription</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
public class PrescriptionForm extends BaseForm {

	/**
	 * Unique prescription ID
	 */
	@NotNull(message = "prescriptionId is required")
	private Long prescriptionId;

	/**
	 * Patient name
	 */
	@NotEmpty(message = "patientName is required")
	private String patientName;

	/**
	 * Doctor name
	 */
	@NotEmpty(message = "doctorName is required")
	private String doctorName;

	/**
	 * Date when prescription was created
	 */
	@NotNull(message = "prescribedDate is required")
	private Date prescribedDate;

	public Long getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(Long prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Date getPrescribedDate() {
		return prescribedDate;
	}

	public void setPrescribedDate(Date prescribedDate) {
		this.prescribedDate = prescribedDate;
	}

	/**
	 * Converts Form data into PrescriptionDTO.
	 *
	 * @return populated PrescriptionDTO object
	 */
	@Override
	public BaseDTO getDto() {

		PrescriptionDTO dto = initDTO(new PrescriptionDTO());
		dto.setPrescriptionId(prescriptionId);
		dto.setPatientName(patientName);
		dto.setDoctorName(doctorName);
		dto.setPrescribedDate(prescribedDate);

		return dto;
	}
}