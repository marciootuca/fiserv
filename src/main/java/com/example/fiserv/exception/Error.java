package com.example.fiserv.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Error implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer code;

	private String description;



}
