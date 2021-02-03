package com.example.fiserv.response;

import com.example.fiserv.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data

public class CompanyResponse {
    private Result result;

    public CompanyResponse(Page<Company> company){
        this.result = new Result(company);
    }

    public CompanyResponse(Company company){
        this.result = new Result(company);
    }
}
