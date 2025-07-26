package com.CollegeAdmission.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="college_master")
public class CollegeMaster {

	@Id
	@Column(name="college_id")
	private Integer collegeId;
	
	@Column(name="college_name")
	private String collegeName;
}
