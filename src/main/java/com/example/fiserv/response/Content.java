package com.example.fiserv.response;

import com.example.fiserv.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content {

    private Long id;

    private String name;

    private String cnpj;

    private Boolean active;

    public static List<Content> list(List<Company> companies){
        return  companies
                .stream()
                .map(Content::new)
                .collect(Collectors.toList());
    }

    public Content(Company company){
        this.id = company.getId();
        this.name = company.getName();
        this.cnpj = company.getCnpj();
        this.active = company.getActive();
    }


}
