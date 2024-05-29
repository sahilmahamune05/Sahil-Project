package com.student.student_management.services;

import java.util.List;

import com.student.student_management.module.Student;

public interface StudentServices {

	public Student addStudent(Student student);
	
	public List<Student>studentList();
	
	public void deleteById(int id);
	
	public Student findById(int id);
	
	public Student updateStudent(Student student);
}
