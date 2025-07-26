package com.CollegeAdmission.service;

import java.util.List;

import com.CollegeAdmission.model.RegistrationDetails;

public interface RegistrationDetailsService {

	RegistrationDetails saveAdmission(RegistrationDetails details);
	
	List<RegistrationDetails> getAllRegistration();

	static RegistrationDetails saveAppointment(RegistrationDetails details) {
		
		return null;
	}

	RegistrationDetails getRegiDetailById(Integer regId);
}
