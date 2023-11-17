package com.infy.hospitalmanagement.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.hospitalmanagement.dto.PatientDTO;
import com.infy.hospitalmanagement.exception.PatientAdmissionException;
import com.infy.hospitalmanagement.service.PatientService;
@RestController
@RequestMapping(value = "/api")
@Validated
public class PatientAPI {
    @Autowired
	private PatientService patientService;
	@GetMapping(value = "/patients/{diagnosis}")
	public ResponseEntity<List<PatientDTO>>getPatientsByDiagnosis(@PathVariable
			@Pattern(regexp = "[A-Za-z0-9]+(\\s[A-Za-z0-9]+)*",
			message = "{patient.diagnosis.invalid}") String diagnosis) throws PatientAdmissionException{
		List<PatientDTO> patientDto = patientService.getListOfPatients(diagnosis);
		return new ResponseEntity<>(patientDto,HttpStatus.OK);
	}
	@PostMapping(value = "/patients")
	public ResponseEntity<PatientDTO>admitPatient(@RequestBody@Valid PatientDTO patientDTO) throws PatientAdmissionException
	{
		PatientDTO patient = patientService.admitPatient(patientDTO);
		return new ResponseEntity<>(patient,HttpStatus.CREATED); 
		
		
	}

}
