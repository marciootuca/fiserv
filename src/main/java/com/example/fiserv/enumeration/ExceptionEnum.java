package com.example.fiserv.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {
	
	INTERNAL_SERVER_ERROR(1, "Internal Server Error"),
	ID_NOT_FOUND(2,"ID não localizado"),
	CNPJ_NOT_FOUND(3,"CNPJ não encontrado"),
	COMPANY_ALREADY_REGISTERED(4, "Empresa já cadastrada");


	
	Integer id;
	String description;

}
