package com.example.fiserv.controller;

import com.example.fiserv.request.CompanyRequest;
import com.example.fiserv.response.CompanyResponse;
import com.example.fiserv.services.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@Api(tags = "Company Controller")
public class CompanyController {

    @Autowired
    private CompanyService service;


    @ApiOperation(value = "Find all companies", notes = "Find all companies", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Find all request successfully executed", response = CompanyResponse.class),
            @ApiResponse(code = 404, message = "The request resource was not found") })
    @GetMapping("/companies")
    public CompanyResponse findAll(@RequestParam(value = "page", defaultValue = "0") Long page,
                                   @RequestParam(value = "size", defaultValue = "10") Long size) {
        return service.findAllPageable(page,size);
    }


    @ApiOperation(value = "Find company by cnpj", notes = "Find company by cnpj", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Find by cnpj request successfully executed", response = CompanyResponse.class),
            @ApiResponse(code = 404, message = "The request resource was not found") })
    @GetMapping("/company/{cnpj}")
    public CompanyResponse findCompanyByCnpj(@PathVariable("cnpj") String cnpj) {
        return service.findByCnpj(cnpj);
    }

    @ApiOperation(value = "Company Registration", notes = "Company Registration", httpMethod = "Post", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "request successfully executed"),
            @ApiResponse(code = 404, message = "The request resource was not found") })
    @PostMapping
    public ResponseEntity save(@RequestBody CompanyRequest companyRequest) {
        return service.save(companyRequest);
    }


    @ApiOperation(value = "Delete company", notes = "Delete company", httpMethod = "DELETE", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "successfully executed"),
            @ApiResponse(code = 404, message = "The request resource was not found") })
    @DeleteMapping("/company/{id}")
    public ResponseEntity deleteCustomer(@PathVariable("id") Long id) {
        return service.delete(id);
    }

}
