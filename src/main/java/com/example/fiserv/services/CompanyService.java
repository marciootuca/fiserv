package com.example.fiserv.services;

import com.example.fiserv.request.CompanyRequest;
import com.example.fiserv.entity.Company;
import com.example.fiserv.enumeration.ExceptionEnum;
import com.example.fiserv.exception.BusinessResponseException;
import com.example.fiserv.exception.Response;
import com.example.fiserv.repository.CompanyRepository;
import com.example.fiserv.response.CompanyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {



    @Autowired
    private CompanyRepository companyRepository;


    public CompanyResponse findAllPageable(Long page, Long size) {
        PageRequest pageRequest = PageRequest.of(page.intValue(),size.intValue(), Sort.by("name").descending());
        Page<Company> company = companyRepository.findAll(pageRequest);
        return new CompanyResponse(company);
    }

    public CompanyResponse findByCnpj(String cnpj){
        return companyRepository.findCompanyByCnpj(cnpj).map(CompanyResponse::new)
                .orElseThrow(() -> new BusinessResponseException(
                        Response.builder()
                                .code(ExceptionEnum.CNPJ_NOT_FOUND.getId())
                                .description(ExceptionEnum.CNPJ_NOT_FOUND.getDescription())
                                .message(ExceptionEnum.CNPJ_NOT_FOUND.getDescription()).build(),
                        HttpStatus.NOT_FOUND));
    }

    public ResponseEntity save(CompanyRequest request){
       companyRepository.findById(request.getId()).ifPresent(result -> {throw new BusinessResponseException(
               Response.builder()
                       .code(ExceptionEnum.COMPANY_ALREADY_REGISTERED.getId())
                       .description(ExceptionEnum.COMPANY_ALREADY_REGISTERED.getDescription())
                       .message(ExceptionEnum.COMPANY_ALREADY_REGISTERED.getDescription()).build(),
               HttpStatus.BAD_REQUEST);
       }
       );

       companyRepository.save(Company.builder()
                              .id(request.getId())
                              .cnpj(request.getCnpj())
                              .active(request.getActive().isStatus())
                              .name(request.getName())
                              .build());

     return ResponseEntity.ok().build();
    }

    public ResponseEntity delete(Long id){
        Company company = companyRepository.findById(id).orElseThrow(() -> new BusinessResponseException(
                Response.builder()
                        .code(ExceptionEnum.ID_NOT_FOUND.getId())
                        .description(ExceptionEnum.ID_NOT_FOUND.getDescription())
                        .message(ExceptionEnum.ID_NOT_FOUND.getDescription()).build(),
                HttpStatus.NOT_FOUND));

        companyRepository.delete(company);

        return ResponseEntity.ok().build();
    }
}
