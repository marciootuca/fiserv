package com.example.fiserv.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer code;

	private String message;

	private String description;
	
	public String toJson() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(this);
	}

}
