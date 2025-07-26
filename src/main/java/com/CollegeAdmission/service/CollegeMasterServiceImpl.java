package com.CollegeAdmission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CollegeAdmission.model.CollegeMaster;
import com.CollegeAdmission.repository.CollegeMasterRepository;

@Service
public class CollegeMasterServiceImpl implements CollegeMasterService {
	
	@Autowired
	CollegeMasterRepository collegeMasterRepository;

	@Override
	public List<CollegeMaster> findAllCollege() {
		return collegeMasterRepository.findAll();
	}
	@Override
	public CollegeMaster getCollegeByCollegeId(Integer cId) {
		return collegeMasterRepository.findById(cId).get();
	}

}
