package com.example.fiserv.request;

import com.example.fiserv.enumeration.ActiveEnum;
import lombok.Data;

import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
public class CompanyRequest {

    @NotNull
    private Long id;

    @NotNull
    @Max(value = 100)
    private String name;

    @NotNull
    @Max(value = 14)
    private String cnpj;

    @Enumerated
    private ActiveEnum active;
}
