package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Patient;
import com.luv2code.springboot.thymeleafdemo.service.PatientService;
// import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {

private PatientService patientService;

public PatientController(PatientService thePatientService) {
	patientService = thePatientService;
}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		//get patient from db
		List<Patient> thePatients = patientService.findAll();
		
		// add to the spring model that can be used in thymeleaf template
		theModel.addAttribute("patients", thePatients);

		return "patients/list-patients";
	}
	
	
@GetMapping("/showFormForAdd")
public String showFormForAdd(Model theModel) {
	//create model attribute to bind form data
	Patient thePatient = new Patient();
	theModel.addAttribute("patient", thePatient);
	
	return "patients/AddPatientForm";
}
@GetMapping("/showFormForAddUser")
public String showFormForAddUser(Model theModel) {
	//create model attribute to bind form data
	Patient thePatient = new Patient();
	theModel.addAttribute("patient", thePatient);
	
	return "patients/addPatientFormUser";
}
@GetMapping("/showAdminIndex")
public String showAdminIndex(Model theModel) {
	//create model attribute to bind form data
	Patient thePatient = new Patient();
	theModel.addAttribute("patient", thePatient);
	
	return "patients/Admin-index";
}
@GetMapping("/showBloodForAdmin")
public String showBloodForAdmin(Model theModel) {
	//create model attribute to bind form data
	Patient thePatient = new Patient();
	theModel.addAttribute("patient", thePatient);
	
	return "patients/admin-blood";
}
@GetMapping("/showAmbulanceForAdmin")
public String showAmbulanceForAdmin(Model theModel) {
	//create model attribute to bind form data
	Patient thePatient = new Patient();
	theModel.addAttribute("patient", thePatient);
	
	return "patients/admin-ambulance";
}
@GetMapping("/showBlog")
public String showBlog(Model theModel) {
	//create model attribute to bind form data
	Patient thePatient = new Patient();
	theModel.addAttribute("patient", thePatient);
	
	return "patients/blog";
}
//@Controller
//public class MyController {
//  
//  @GetMapping("/example")
//  public String example(Model model) {
//    // Define the variables and set their values
//    String option1Value = "Dr.Rajesh Maharjan -12th July,2023 ";
//    String option2Value = "Dr.Shsir Pradhan -15th July,2023";
//    String option3Value = "Dr.Sajen Tul -16th July,2023 ";
//    
//    // Add the variables to the model
//    model.addAttribute("option1Value", option1Value);
//    model.addAttribute("option2Value", option2Value);
//    model.addAttribute("option3Value", option3Value);
//    
//    // Return the name of the Thymeleaf template
//    return "example-template";
//  }
//}

@GetMapping("/showFormForUpdate")
public String showFormForUpdate(@RequestParam("patientId")int theId, Model theModel) {
	//get the patient from the service
	Patient thePatient = patientService.findById(theId);
	//set the patient in the model to pre populate the form
	theModel.addAttribute("patient",thePatient);
	//send over to our form
	return "patients/AddPatientForm";
}

@PostMapping("/save")
public String savePatient(@ModelAttribute("patient") Patient thePatient) {
	
	//save the patient
	patientService.save(thePatient);
	
	//use a redirect to prevent duplicate submissions
	return "redirect:/patients/list";
}
@PostMapping("/newForm")
public String savePatientUser(@ModelAttribute("patient") Patient thePatient) {
	
	//save the patient
	patientService.save(thePatient);
	
	//use a redirect to prevent duplicate submissions
	return "redirect:/patients/showFormForAddUser";
}
	
@GetMapping("/delete")
public String delete(@RequestParam("patientId")int theId) {
	//delete the patient
	patientService.deleteById(theId);
	
	//redirect to the /patient/list
	return "redirect:/patients/list";
}

}









