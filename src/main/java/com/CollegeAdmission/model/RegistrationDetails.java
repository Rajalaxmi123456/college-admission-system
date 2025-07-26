package com.CollegeAdmission.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class RegistrationDetails {

		@Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		
		@Column(name="registration_id")
		private Integer regId;
		
		@Column(name="applicant_name")
		private String appName;
		
		@Column(name="email_id")
		private String email;
		
		@Column(name="mobile_no")
		private String mobile;
		
		@Column(name="gender")
		private Character gender;
		
		@Column(name="dob")
		private Date dob;
		
		@Column(name="image_path")
		private String imagepath;
		
		@ManyToOne
		@JoinColumn(name="c_id",referencedColumnName = "college_id")
		private CollegeMaster collegeMaster;
		
		@ManyToOne
		@JoinColumn(name="branch_id")
		private BranchMaster branchMaster;

}
		
