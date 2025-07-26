package com.CollegeAdmission.controller;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CollegeAdmission.model.BranchMaster;
import com.CollegeAdmission.model.CollegeMaster;
import com.CollegeAdmission.model.RegistrationDetails;
import com.CollegeAdmission.service.BranchMasterService;
import com.CollegeAdmission.service.BranchMasterServiceImpl;
import com.CollegeAdmission.service.CollegeMasterService;
import com.CollegeAdmission.service.CollegeMasterServiceImpl;
import com.CollegeAdmission.service.RegistrationDetailsService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/home")
public class AdmissionController {
	
	@Autowired
	CollegeMasterService collegeMasterService;
	
	@Autowired
    BranchMasterService branchMasterService;
	
	@Autowired
	RegistrationDetailsService registrationDetailsService;
	
	@GetMapping("/index")
	public String homepage(Model model) {
		
		List<CollegeMaster> collegeList = collegeMasterService.findAllCollege();
		model.addAttribute("cList",collegeList);
		
		List<RegistrationDetails> regList = registrationDetailsService.getAllRegistration();
		model.addAttribute("regList",regList);
		
		return "index";
	}
	
	@PostMapping("/getBranch")
	public void getBranch(@RequestParam("cId")Integer cId,
		HttpServletResponse response) throws IOException{
	
	System.out.println(cId);
	
	List<BranchMaster> branchList = branchMasterService.findBranchByCollegeId(cId);
	
	String option = "<option value ='-1'>--select--</option>";
	
	for(BranchMaster x:branchList) {
		option = option+"<option value='"+x.getBranchId()+"'>"+x.getBranchName()+"</option>";
	}
	
	System.out.println(option);
	
	response.getWriter().print(option);
}


	@PostMapping("/saveAdmission")
	public String saveAdmission(
	@RequestParam("college")Integer cId,
	@RequestParam("branch")Integer bId,
	@RequestParam("name")String name,
	@RequestParam("email")String email,
	@RequestParam("mobile")String mobile,
	@RequestParam("dob")String dob,
	@RequestParam("gender")Character gender,
	@RequestParam("photo")MultipartFile photo, RedirectAttributes rd) throws ParseException{

	RegistrationDetails details= new RegistrationDetails();
	details.setAppName(name);
	details.setEmail(email);
	details.setMobile(mobile);
	details.setGender(gender);
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	Date converDate = format.parse(dob);
	
	details.setDob(converDate);
	details.setImagepath(photo.getOriginalFilename());
	details.setCollegeMaster(collegeMasterService.getCollegeByCollegeId(cId));
	details.setBranchMaster(branchMasterService.getBranchByBranchId(bId));
	
	
	try {
		RegistrationDetails savedDetails = registrationDetailsService.saveAdmission(details);
		rd.addFlashAttribute("msg","success");
	}
	catch(Exception e) {
		rd.addFlashAttribute("msg", "error");
	}
	return "redirect:./index";
	}
	
	@PostMapping("getFeeByBranch")
	public void getFee(@RequestParam("bId")Integer bId,HttpServletResponse response)throws IOException{
		System.out.println("Hiii");
		Double fees= branchMasterService.getFeeByBranch(bId);
		
		String input= "<input type='text' class='form-control bg-danger text-light' value='"+fees+"' disabled>";
		
		response.getWriter().print(input);
	}
	@GetMapping("/deleteRegDetails")
	public String deleteRegDetails(@RequestParam("regId") Integer regId) {
		RegistrationDetails deleteDetails= registrationDetailsService.getRegiDetailById(regId);
		
		//registrationDetailsService.deleteRegistrationDetails(deleteDetails);
		
		return "redirect:./index";
	}
	
}
