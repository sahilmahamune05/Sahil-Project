package com.employee.employee_management.services;

import java.util.List;

import com.employee.employee_management.module.Employee;

public interface EmployeeServices {

	public Employee saveEmployee(Employee employee);
	
	public List<Employee>empList();
	
	public void deleteById(int id);
	
	public Employee findById(int id);
	
	public Employee updateEmployee(Employee employee);
}
