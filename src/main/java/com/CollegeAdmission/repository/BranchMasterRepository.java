package com.CollegeAdmission.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CollegeAdmission.model.BranchMaster;
import com.CollegeAdmission.model.CollegeMaster;

@Repository
public interface BranchMasterRepository extends JpaRepository<BranchMaster, Integer>{

	List<BranchMaster> findAllBranchMasterByCollegeMaster(CollegeMaster collegemaster);
}
