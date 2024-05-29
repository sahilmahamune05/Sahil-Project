package com.employee.employee_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.employee_management.module.Employee;
import com.employee.employee_management.module.EmployeeLogin;
import com.employee.employee_management.services.EmployeeServices;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {

	static int id;
	@Autowired
	private EmployeeServices es;
	
	//Create Operation
	@GetMapping("/registeremployee")
	public String regiStudent(Model model) {
		model.addAttribute("employee", new Employee());
		return "employeeRegistration";
		
	}
	
	@PostMapping("/status")
	public String getStatus(@Valid @ModelAttribute("employee") Employee employee, BindingResult br) {
		
		if(br.hasErrors()) {
			return "employeeRegistration";
		}
		es.saveEmployee(employee);
		return "redirect:/employeelogin";
		
	}
	
	@GetMapping("/employeelogin")
	public String getLogin(Model model) {
		model.addAttribute("employeelogin", new EmployeeLogin());
		return "employeelogin";
		
	}
	
	
	@PostMapping("/employeeloginstatus")
	public String logStatus(@Valid @ModelAttribute("employeelogin")EmployeeLogin employeelogin, BindingResult br , Model model) {
		
		
		if(br.hasErrors()) {
			return "redirect:/employeelogin";
		}
		
		List<Employee> dbEmployee= es.empList();
		boolean found  = false;
		for(Employee em: dbEmployee) {
			if(em.getUsername().equals(employeelogin.getUsername()) && em.getPassword().equals(employeelogin.getPassword())) {
				id= em.getId();
				model.addAttribute("employee", em);
				found = true;
				break;
			}
		}
		if(found) {
			return "employeehome";
		}
		
		else {
			model.addAttribute("error" , "Incorrect username or password");
			return "employeelogin";
		}
		
		
	}
	
	
	//Delete Operation
	@PostMapping("/employee/delete")
	public String deleteStudent(@RequestParam("id") int id, Model model) {
		es.deleteById(id);
		
		return "redirect:/employeelogin";
		
	}
	
	//Edit Operation
	@GetMapping("/employee/edit")
	public String getEdit(Model model) {
		
		Employee findEmployee = es.findById(id);
		model.addAttribute("employee", findEmployee);
		return "employeeupdateform";
		
	}
	
	@PostMapping("/employeesaveupdate")
	public String getupdate(@Valid @ModelAttribute("employee")Employee employee, BindingResult br) {
//		if(br.hasErrors()) {
//			return "studentupdateform";
//		}
		es.updateEmployee(employee);
		return "employeehome";
		
	}
	

}
