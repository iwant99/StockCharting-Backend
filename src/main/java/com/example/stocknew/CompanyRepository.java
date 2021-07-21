package com.example.stocknew;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    boolean existsByName(String Name);
    @Query("select c from Company c where c.code = ?1")
    Company findCompanyByCode(Long Code);
    @Modifying
    @Query("DELETE  from Company c where c.code = ?1")
    Company deleteCompanyByCode(Long Code);



}