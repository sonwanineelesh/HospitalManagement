package com.infy.hospitalmanagement.validator;

import java.time.LocalDate;

import com.infy.hospitalmanagement.dto.PatientDTO;
import com.infy.hospitalmanagement.exception.PatientAdmissionException;

public class PatientValidator {

	public PatientValidator() {
		super();
		// TODO Auto-generated constructor stub
	}
   public static void validatePatient(PatientDTO patientDTO) throws PatientAdmissionException
   {
	   if(!isValidDateOfBirth(patientDTO.getDateOfBirth())) {
		   throw new PatientAdmissionException("PatientValidator.INVALID_DOB");
	   }
   }
   public static Boolean isValidDateOfBirth(LocalDate dateOfBirth) throws PatientAdmissionException
   {
	  if(dateOfBirth.isAfter(LocalDate.now())||dateOfBirth.isBefore(LocalDate.now().minusYears(100))) {
		  return false;
	  }
	return true;   
   }
}
