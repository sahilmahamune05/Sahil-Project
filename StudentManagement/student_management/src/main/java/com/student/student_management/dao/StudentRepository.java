package com.student.student_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.student_management.module.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	

}
