package com.example.fiserv.repository;

import com.example.fiserv.entity.Company;
import com.example.fiserv.response.CompanyResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository  extends JpaRepository<Company, Long> {

    Page<Company> findAll(Pageable pageable);

    Optional<Company> findCompanyByCnpj(String cnpj);
}
