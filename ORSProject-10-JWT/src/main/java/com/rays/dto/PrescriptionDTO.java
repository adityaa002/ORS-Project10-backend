package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_prescription")
public class PrescriptionDTO extends BaseDTO {

	@Column(name = "prescription_id", length = 50)
	private Long prescriptionId;
	
	@Column(name = "patient_name", length = 50)
	private String patientName;
	
	@Column(name = "doctor_name", length = 50)
	private String doctorName;
	
	@Column(name = "prescribed_date", length = 50)
	private Date prescribedDate;

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "doctorName";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return doctorName;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "Prescription";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Prescription";
	}

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
}
