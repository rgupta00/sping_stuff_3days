package com.productapp.util;
import java.util.*;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.productapp.dto.ErrorMessage;
import com.productapp.exception.ProductNotFoundException;

@RestControllerAdvice
public class ProductAppExceptionHandlerController {

	@ExceptionHandler(ProductNotFoundException.class)
	ResponseEntity<ErrorMessage> handle404(ProductNotFoundException ex){
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setDateTime(LocalDateTime.now());
		errorMessage.setMessage(ex.getMessage());
		errorMessage.setStatusCode(HttpStatus.NOT_FOUND.toString());
		errorMessage.setToContact("rgupta.mtech@gmail.com");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
		
	}
	
	//@ExceptionHandler(Exception.class)
	ResponseEntity<ErrorMessage> handle500(Exception ex){
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setDateTime(LocalDateTime.now());
		errorMessage.setMessage("please try after some time");
		errorMessage.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		errorMessage.setToContact("rgupta.mtech@gmail.com");
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	Map<String, String> handle400(MethodArgumentNotValidException ex){
		
		//i want to extract out error from exception 
		Map<String, String> errorMap=new HashMap<String, String>();
		
		ex.getBindingResult().getFieldErrors().forEach(e-> errorMap.put(e.getField(), e.getDefaultMessage()));
		
		
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setDateTime(LocalDateTime.now());
		errorMessage.setMessage("there is a validation error");
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.toString());
		errorMessage.setToContact("rgupta.mtech@gmail.com");
		
		return errorMap;
		
	}
	
	
}
