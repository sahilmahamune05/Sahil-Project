package com.employee.employee_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.employee_management.module.Employee;

public interface EmployeeRepo  extends JpaRepository<Employee, Integer>{

}
