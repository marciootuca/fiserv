package com.example.fiserv.response;

import com.example.fiserv.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagination {
    private Long limit;
    private Long offset;
    private Long returnedRecords;
    private String sort;
    private Long totalRecords;
    private Long totalPages;

    public Pagination(Page<Company> page){
        this.limit = Long.valueOf(page.getSize());
        this.offset = Long.valueOf(page.getNumber());
        this.returnedRecords = Long.valueOf(page.getNumberOfElements());
        this.sort = page.getSort().toString();
        this.totalPages = Long.valueOf(page.getTotalPages());
        this.totalRecords = page.getTotalElements();


    }
}
