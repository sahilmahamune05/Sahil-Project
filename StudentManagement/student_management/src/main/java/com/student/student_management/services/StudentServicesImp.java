package com.student.student_management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.student_management.dao.StudentRepository;
import com.student.student_management.module.Student;

@Service
public class StudentServicesImp implements StudentServices{
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public Student addStudent(Student student) {
		
		return studentRepo.save(student);
	}

	@Override
	public List<Student> studentList() {
		
		List<Student> findAll = studentRepo.findAll();
		return findAll;
	}

	@Override
	public void deleteById(int id) {
		
		studentRepo.deleteById(id);
	}

	@Override
	public Student findById(int id) {
		
		Optional<Student> findById = studentRepo.findById(id);
		Student student = findById.get();
		return student;
	}

	@Override
	public Student updateStudent(Student student) {
	
		return studentRepo.save(student);
	}

}
