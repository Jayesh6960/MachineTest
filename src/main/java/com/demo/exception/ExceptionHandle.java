package com.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {
	
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<String> resourseNotFound(ResourseNotFoundException ex){
		String m= "Resourse not found: " + ex.getMessage();
		return new ResponseEntity<String>(m,HttpStatus.NOT_FOUND);
	}
}
