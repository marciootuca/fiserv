package com.example.fiserv.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorResponseException extends RuntimeException {

	private static final long serialVersionUID = -947909800477869008L;

	private final Response response;

	private final HttpStatus status;

	public ErrorResponseException() {
		this(null, null);
	}

	public ErrorResponseException(final Response response, final HttpStatus httpStatus) {
		super();
		this.response = response;
		this.status = httpStatus;
	}

}