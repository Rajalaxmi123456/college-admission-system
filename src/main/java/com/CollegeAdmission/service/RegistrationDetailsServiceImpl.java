package com.CollegeAdmission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CollegeAdmission.model.RegistrationDetails;
import com.CollegeAdmission.repository.RegistrationDetailsRepository;

@Service
public class RegistrationDetailsServiceImpl implements RegistrationDetailsService{
	
	@Autowired
	RegistrationDetailsRepository registrationDetailsRepository;
	
	@Override
	public RegistrationDetails saveAdmission(RegistrationDetails details) {
		return registrationDetailsRepository.save(details);
	}

	@Override
	public List<RegistrationDetails> getAllRegistration() {
		return registrationDetailsRepository.findAll();
	}

	@Override
	public RegistrationDetails getRegiDetailById(Integer regId) {
		
		RegistrationDetails regi=registrationDetailsRepository.findById(regId).get();
		registrationDetailsRepository.delete(regi);
		return regi;
	}

}
