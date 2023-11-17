package com.infy.hospitalmanagement.dto;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.infy.hospitalmanagement.entity.Patient;

public class PatientDTO 
{
	private Integer patientId;
	@NotNull(message = "{patient.name.notpresent}")
	@Pattern(regexp = "[a-zA-Z]+(\\s[a-zA-Z]+)*",message = "{patient.name.invalid}")
	private String patientName;
	@NotNull(message = "{patient.gender.notpresent}")
	@Pattern(regexp = "(Male|Female|Others)",message = "{patient.gender.invalid}")
	private String gender;
	private LocalDate dateOfBirth;
	@NotNull(message = "{patient.admissiondate.notpresent}")
	@PastOrPresent(message = "{patient.admissiondate.invalid}")
	@FutureOrPresent(message = "{patient.admissiondate.invalid}")
	private LocalDate admissionDate;
	@NotNull(message = "{patient.diagnosis.notpresent}")
	@Pattern(regexp = "[A-Za-z0-9]+([\\sA-Za-z0-9]+)*",message = "{patient.diagnosis.invalid}")
	private String diagnosis;
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public LocalDate getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public static PatientDTO prepareDTO(Patient p) {
		// TODO Auto-generated method stub
		return null;
	}
	public static Patient prepareEntity(PatientDTO patientDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
