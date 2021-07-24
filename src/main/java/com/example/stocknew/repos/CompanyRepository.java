package com.example.stocknew.repos;

import com.example.stocknew.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    boolean existsByName(String Name);
    @Query("select c from Company c where c.code = ?1")
    Company findCompanyByCode(Long Code);
    @Query("DELETE  from Company c where c.code = ?1")
    Company deleteCompanyByCode(Long Code);



}