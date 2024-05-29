package com.employee.employee_management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employee_management.dao.EmployeeRepo;
import com.employee.employee_management.module.Employee;

@Service
public class EmployeeServicesImp implements EmployeeServices {

	@Autowired
	private EmployeeRepo empRepo;
	@Override
	public Employee saveEmployee(Employee employee) {
		
		return empRepo.save(employee);
	}

	@Override
	public List<Employee> empList() {
		
		List<Employee> findAll = empRepo.findAll();
		return findAll;
	}

	@Override
	public void deleteById(int id) {
	
		empRepo.deleteById(id);
		
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> findById = empRepo.findById(id);
		Employee employee =  findById.get();
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empRepo.save(employee);
	}

}
