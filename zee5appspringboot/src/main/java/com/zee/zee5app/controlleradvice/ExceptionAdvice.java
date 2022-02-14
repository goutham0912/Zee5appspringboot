package com.zee.zee5app.controlleradvice;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.RecordExists;
import com.zee.zee5app.exception.apierror.ApiError;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {
//class should be used when user defined exception is called throuhout the controller
	@ExceptionHandler(RecordExists.class)
	public ResponseEntity<?> recordAlreadyExists(RecordExists e)
	{
		Map<String,String> hashMap=new HashMap<>();
		hashMap.put("message","Record already exists"+e.getMessage());
		return ResponseEntity.badRequest().body(hashMap);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptionHandler(Exception e)
	{
		Map<String,String> hashMap=new HashMap<>();
		hashMap.put("message",e.getMessage());
		return ResponseEntity.badRequest().body(hashMap);
	}
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<?> idNotFound(IdNotFoundException e)
	{
		Map<String,String> hashMap=new HashMap<>();
		hashMap.put("message",e.getMessage());
		return ResponseEntity.badRequest().body(hashMap);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		ApiError apiError=new ApiError(HttpStatus.BAD_REQUEST);
		apiError.setMessage("Validation error");
//		return super.handleMethodArgumentNotValid(ex, headers, status, request);
		apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
		apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
		return buildResponseEntity(apiError);
	}
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError)
	{
		//if we want to make changes in our existing object ,then in every return we have to do the change
		//so we use buildre method
		return new ResponseEntity<>(apiError,apiError.getHttpStatus());
	}
	@ExceptionHandler(ConstraintViolationException.class)
	private ResponseEntity<?> handleConstraintViolation()
	{
		return null;
	}
	
}
