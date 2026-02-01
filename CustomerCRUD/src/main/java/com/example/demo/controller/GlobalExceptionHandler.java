package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.DuplicateID;
import com.example.demo.exception.DuplicateMobNo;
import com.example.demo.exception.DuplicateName;
import com.example.demo.exception.InvalidID;
import com.example.demo.exception.InvalidMobileNumber;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidMobileNumber.class)
	public ResponseEntity<?> InvalidMobileNumber(InvalidMobileNumber e) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}

	@ExceptionHandler(InvalidID.class)
	public ResponseEntity<?> InvalidID(InvalidID e) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());

	}

	@ExceptionHandler(DuplicateID.class)
	public ResponseEntity<?> DuplicateID(DuplicateID e) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}

	@ExceptionHandler(DuplicateName.class)
	public ResponseEntity<?> DuplicateName(DuplicateName e) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	
	@ExceptionHandler(DuplicateMobNo.class)
	public ResponseEntity<?>DuplicateMobNo(DuplicateMobNo e){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}

}
