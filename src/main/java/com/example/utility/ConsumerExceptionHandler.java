package com.example.utility;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import com.example.exception.ConsumerDeleteException;

@RestControllerAdvice
public class ConsumerExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorInfo> handleHttpClientErrorException(HttpClientErrorException exception){
		ErrorInfo error=new ErrorInfo();
		error.setErrorcode(HttpStatus.NOT_FOUND);
		error.setMessage(exception.getMessage());
		error.setTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorInfo> handleHttpClientErrorException(ConsumerDeleteException exception){
		ErrorInfo error=new ErrorInfo();
		error.setErrorcode(HttpStatus.NOT_FOUND);
		error.setMessage(exception.getMessage());
		error.setTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}
}


