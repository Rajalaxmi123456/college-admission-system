package com.CollegeAdmission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CollegeAdmission.model.BranchMaster;
import com.CollegeAdmission.model.CollegeMaster;
import com.CollegeAdmission.repository.BranchMasterRepository;
import com.CollegeAdmission.repository.CollegeMasterRepository;

@Service
public class BranchMasterServiceImpl implements BranchMasterService{
	
	@Autowired
	BranchMasterRepository branchMasterRepository;
	
	@Autowired
	CollegeMasterRepository collegeMasterRepository;
	
	@Override
	public List <BranchMaster> findBranchByCollegeId(Integer cId) {
		CollegeMaster collegemaster = collegeMasterRepository.findById(cId).get();
		return branchMasterRepository.findAllBranchMasterByCollegeMaster(collegemaster) ;
	}
	
	@Override
	public BranchMaster getBranchByBranchId(Integer bId) {
		return branchMasterRepository.findById(bId).get();
	}
	
	@Override
	public Double getFeeByBranch(Integer bId) {
		return branchMasterRepository.findById(bId).get().getFees() ;

}
}
