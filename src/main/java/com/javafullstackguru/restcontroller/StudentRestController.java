package com.javafullstackguru.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javafullstackguru.entity.Student;
import com.javafullstackguru.exception.StudentNotFoundException;
import com.javafullstackguru.service.StudentServiceImpl;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

@RestController
public class StudentRestController {
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@PostMapping("/student")
	public ResponseEntity<Student> createSingleStudent(@RequestBody Student student){
		Student createdStudent = studentServiceImpl.createSingleStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
	}
	
	@PostMapping("/students")
	public ResponseEntity<List<Student>> createStudents(@RequestBody List<Student> studentList){
		List<Student> createStudents =  studentServiceImpl.createStudents(studentList);
		return ResponseEntity.status(HttpStatus.CREATED).body(createStudents);
		
	}
	@GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {
        try {
            Student student = studentServiceImpl.getStudentById(id);
            return ResponseEntity.ok(student);
        } catch (StudentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		return ResponseEntity.ok(studentServiceImpl.getAllStudents());
	}
	
	@PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable("id") Integer id,  // Explicitly specify parameter name
            @RequestBody Student student) {
        
        try {
            Student updatedStudent = studentServiceImpl.UpdateStudent(id, student);
            return ResponseEntity.ok(updatedStudent);
        } catch (StudentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
	
	@DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Integer id) {
        try {
            studentServiceImpl.deleteStudent(id);
            return ResponseEntity.noContent().build();
        } catch (StudentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
	
	
	
	
	

}
