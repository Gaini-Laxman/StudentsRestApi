package com.javafullstackguru.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(StudentAlreadyExistException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ResponseEntity<String> handleStudentAlreadyExistException(StudentAlreadyExistException studentAlreadyExistException){
		return new ResponseEntity<>(studentAlreadyExistException.getMessage(), HttpStatus.CONFLICT);	
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException studentNotFoundException){
		return new ResponseEntity<>(studentNotFoundException.getMessage(), HttpStatus.NOT_FOUND);	
	}
	

}
