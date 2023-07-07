package com.facebook.config;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.facebook.exception.ResourceNotFoundException;
import com.facebook.httpresponse.HttpErrorResponse;
import com.facebook.httpresponse.HttpUserErrorResponse;
import com.facebook.util.ResponseUtil;


@ControllerAdvice
public class ControllerAdvicerConfig {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<HttpUserErrorResponse> handleInvalidArgument(MethodArgumentNotValidException e){
		Map<String,String> error = new HashMap<>();
		e.getBindingResult().getFieldErrors().forEach(err -> {
			error.put(err.getField(), err.getDefaultMessage());
		});
		return ResponseUtil.prepareFailedResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),error);
	}
	

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<HttpUserErrorResponse> handleValidationException(NoSuchElementException e) {
		Map<String,String> error = new HashMap<>();
		error.put("error", e.getMessage());
	
		return ResponseUtil.prepareFailedResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),error);

	}
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<HttpErrorResponse> handleResourceNotFound(ResourceNotFoundException e){
		return ResponseUtil.setCommentFailedResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
	}
}
