package com.CollegeAdmission.service;

import java.util.List;

import com.CollegeAdmission.model.BranchMaster;

public interface BranchMasterService {

	List<BranchMaster> findBranchByCollegeId(Integer cId);
	
	BranchMaster getBranchByBranchId(Integer bId);
	
		Double getFeeByBranch(Integer bId);
}
