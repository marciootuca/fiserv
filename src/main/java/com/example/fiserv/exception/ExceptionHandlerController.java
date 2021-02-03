package com.example.fiserv.exception;


import com.example.fiserv.enumeration.ExceptionEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(BusinessResponseException.class)
	public ResponseEntity<Response> handleBusinessResponseException(BusinessResponseException ex) {
		return new ResponseEntity<>(ex.getResponse(), ex.getStatus());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> handleException(Exception ex) {
		return new ResponseEntity<>(
				Response.builder()
						.code(ExceptionEnum.INTERNAL_SERVER_ERROR.getId())
						.description(ExceptionEnum.INTERNAL_SERVER_ERROR.getDescription())
						.message(ex.getMessage())
						.build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	

}
