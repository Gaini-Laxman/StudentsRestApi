package com.javafullstackguru.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javafullstackguru.entity.Student;



public interface StudentService {

	Student createSingleStudent(Student student);
	
	List<Student> createStudents(List<Student> studentaList);
	
	Student getStudentById(Integer id);
	
	List<Student> getAllStudents();
	
	Student UpdateStudent(Integer id, Student student);
	
	void deleteStudent(Integer id);
	
	
}
