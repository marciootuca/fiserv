package com.example.fiserv.response;

import com.example.fiserv.entity.Company;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.Arrays;
import java.util.List;

@Data
public class Result {

    private List<Content> content;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Pagination pagination;

    public Result(Page<Company> company){
        this.content =  Content.list(company.getContent());
        this.pagination = new Pagination(company);

    }

    public Result(Company company){
        this.content =  Content.list(Arrays.asList(company));
    }
}
