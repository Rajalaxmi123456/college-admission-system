package com.CollegeAdmission.service;

import java.util.List;

import com.CollegeAdmission.model.CollegeMaster;

public interface CollegeMasterService {

	List<CollegeMaster> findAllCollege();
	
	CollegeMaster getCollegeByCollegeId(Integer cId);
	
}

