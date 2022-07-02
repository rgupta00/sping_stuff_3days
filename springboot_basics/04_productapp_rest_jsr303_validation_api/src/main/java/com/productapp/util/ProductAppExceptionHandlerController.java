package com.productapp.util;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	
	@ExceptionHandler(Exception.class)
	ResponseEntity<ErrorMessage> handle500(Exception ex){
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setDateTime(LocalDateTime.now());
		errorMessage.setMessage("please try after some time");
		errorMessage.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		errorMessage.setToContact("rgupta.mtech@gmail.com");
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		
	}
	
}
