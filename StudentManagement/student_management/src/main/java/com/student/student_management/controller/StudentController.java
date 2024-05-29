package com.student.student_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.student_management.module.Student;
import com.student.student_management.module.StudentLogin;
import com.student.student_management.services.StudentServices;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

@Controller
public class StudentController {
	static int id;
	
	@Autowired
	private StudentServices st;
	
	//Create Operation
	@GetMapping("/registerstudent")
	public String regiStudent(Model model) {
		model.addAttribute("student", new Student());
		return "studentRegistration";
		
	}
	
	@PostMapping("/status")
	public String getStatus(@Valid @ModelAttribute("student") Student student, BindingResult br) {
		
		if(br.hasErrors()) {
			return "studentRegistration";
		}
		st.addStudent(student);
		return "redirect:/studentlogin";
		
	}
	
	@GetMapping("/studentlogin")
	public String getLogin(Model model) {
		model.addAttribute("studentlogin", new StudentLogin());
		return "studentlogin";
		
	}
	
	
	@PostMapping("/studentloginstatus")
	public String logStatus(@Valid @ModelAttribute("studentlogin")StudentLogin studentlogin, BindingResult br , Model model) {
		
		
		if(br.hasErrors()) {
			return "redirect:/studentlogin";
		}
		
		List<Student> dbStudent= st.studentList();
		boolean found  = false;
		for(Student sd: dbStudent) {
			if(sd.getUsername().equals(studentlogin.getUsername()) && sd.getPassword().equals(studentlogin.getPassword())) {
				id= sd.getId();
				model.addAttribute("student", sd);
				found = true;
				break;
			}
		}
		if(found) {
			return "studenthome";
		}
		
		else {
			model.addAttribute("error" , "Incorrect username or password");
			return "studentlogin";
		}
		
		
		
		
		
	}
	
	//Delete Operation
	@PostMapping("/student/delete")
	public String deleteStudent( @RequestParam("id") int id, Model model) {
		st.deleteById(id);
		
		return "redirect:/studentlogin";
		
	}
	
	//Edit Operation
	@GetMapping("/student/edit")
	public String getEdit(Model model) {
		
		Student findStudent = st.findById(id);
		model.addAttribute("student", findStudent);
		return "studentupdateform";
		
	}
	
	@PostMapping("/studentsaveupdate")
	public String getupdate(@Valid @ModelAttribute("student")Student student, BindingResult br) {
//		if(br.hasErrors()) {
//			return "studentupdateform";
//		}
		st.updateStudent(student);
		return "studenthome";
		
	}
	
	
	
	
	
}
