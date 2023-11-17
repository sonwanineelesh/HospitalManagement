package com.infy.hospitalmanagement.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.hospitalmanagement.dto.PatientDTO;
import com.infy.hospitalmanagement.entity.Patient;
import com.infy.hospitalmanagement.exception.PatientAdmissionException;
import com.infy.hospitalmanagement.repository.PatientRepository;
import com.infy.hospitalmanagement.validator.PatientValidator;
@Service(value = "patientService")
@Transactional
public class PatientServiceImpl  implements PatientService{
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public List<PatientDTO> getListOfPatients(String diagnosis) throws PatientAdmissionException {
		// TODO Auto-generated method stub
		List<Patient> patients = patientRepository.findByDiagnosis(diagnosis);
		if(patients.isEmpty()) {
			throw new PatientAdmissionException("PatientService.PATIENT_UNAVAILABLE");
		}
		List<PatientDTO> patientDto = new ArrayList<>();
		patients.stream().forEach((p)->{
			patientDto.add(PatientDTO.prepareDTO(p));
		});
		patientDto.sort((s1,s2)->s2.getAdmissionDate().compareTo(s1.getAdmissionDate()));
		return patientDto;
	}

	@Override
	public PatientDTO admitPatient(PatientDTO patientDTO) throws PatientAdmissionException {
		// TODO Auto-generated method stub
		PatientValidator.validatePatient(patientDTO);
		Patient patient = PatientDTO.prepareEntity(patientDTO);
		patient= patientRepository.save(patient);
		patientDTO.setPatientId(patient.getPatientId());
		return patientDTO;
	}

}
