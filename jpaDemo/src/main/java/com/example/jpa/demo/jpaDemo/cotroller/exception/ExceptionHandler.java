package com.example.jpa.demo.jpaDemo.cotroller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.example.jpa.demo.jpaDemo.model.exception.ProductNotFoundException;

@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = ProductNotFoundException.class)
	
	public ResponseEntity<Object> productNotFound(ProductNotFoundException exception) {
		return new ResponseEntity("product not found", HttpStatus.NOT_FOUND);
	}

}
