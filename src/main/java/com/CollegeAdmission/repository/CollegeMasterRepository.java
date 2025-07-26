package com.CollegeAdmission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CollegeAdmission.model.CollegeMaster;

@Repository
public interface CollegeMasterRepository extends JpaRepository<CollegeMaster,Integer>{

}