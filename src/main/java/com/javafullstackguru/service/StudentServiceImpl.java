package com.javafullstackguru.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafullstackguru.entity.Student;
import com.javafullstackguru.exception.StudentAlreadyExistException;
import com.javafullstackguru.exception.StudentNotFoundException;
import com.javafullstackguru.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student createSingleStudent(Student student) {
		if (studentRepository.existsById(student.getId())) {
			throw new StudentAlreadyExistException("Student Already exist with ID : " + student.getId());
		}
		return studentRepository.save(student);
	}

	@Override
	public List<Student> createStudents(List<Student> studentaList) {
		for(Student student : studentaList) {
			if(studentRepository.existsById(student.getId())) {
				throw new StudentAlreadyExistException("Student already exist with ID : " + student.getId());
			}
		}
		return studentRepository.saveAll(studentaList);
	}

	@Override
	public Student getStudentById(Integer id) {
		
		return studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student not found with ID :" +id));
	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student UpdateStudent(Integer id, Student student) {
		if (!studentRepository.existsById(id)) {
			throw new StudentNotFoundException("Cant update, Student not found with ID : " + id);
		}
		student.setId(id);
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(Integer id) {
		Student student = studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Cant Delete, Student not found with ID : " + id));
		studentRepository.delete(student);
	}
	
	

}
