package com.example.stocknew.controllers;

import com.example.stocknew.services.AdminService;
import com.example.stocknew.models.Company;
import com.example.stocknew.models.CompanyDTO;
import com.example.stocknew.models.StockExchange;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("")
    public String admin() {
        return ("<h1>welcome admin!</h1>");
    }

    @PostMapping("/addcompany")
    public ResponseEntity<?> addCompany(@Valid @RequestBody CompanyDTO companyDTO) {
        return ResponseEntity.ok(adminService.addCompany(companyDTO));
    }

    @DeleteMapping("/deletecompany/id={id}")
    public ResponseEntity<?> deleteCompanyById(@PathVariable("id") Long id) {
        Optional<Company> company = adminService.findById(id);
        System.out.println("its here");
        if (company.isPresent()) {
            adminService.deleteCompanyById(id);
            return ResponseEntity.ok("successfully deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("company id doesnt exists");

    }

    @DeleteMapping("/deletecompany/code={code}")
    public ResponseEntity<?> deleteCompanyByCode(@PathVariable("code") Long code) {
        if (adminService.findCompanyByCode(code) != null) {
            adminService.deleteCompanyByCode(code);
            return ResponseEntity.ok("successfully deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("company id doesnt exists");

    }

    @PostMapping("/updatecompany/id={id}")
    public ResponseEntity<?> updateCompanyById(@PathVariable("id") Long id, @RequestBody CompanyDTO companyDTO) {
        if (adminService.findById(id).isPresent()) {
            Company company = adminService.updateCompanyById(id, companyDTO);
            if (company != null) {
                return ResponseEntity.ok(company);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("company could not be updated");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("company id doesnt exists");
    }

    @GetMapping("/getallcompanies")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(adminService.getAll());
    }

    @GetMapping("/getallsectors")
    public ResponseEntity<?> getAllSectors() {
        return ResponseEntity.ok(adminService.getAllSectors());
    }

    @GetMapping("/getcompany/id={id}")
    public ResponseEntity<?> getCompany(@PathVariable("id") Long id) {
        Optional<Company> company = adminService.findById(id);
        if (company.isPresent()) {
            return ResponseEntity.ok(company.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("company id doesnt exists");
    }

    @GetMapping("/getcompany/code={code}")
    public ResponseEntity<?> getCompanyByCode(@PathVariable("code") Long code) {
        Company company = adminService.findCompanyByCode(code);
        if (company != null) {
            return ResponseEntity.ok(company);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("company code doesnt exists");
    }

    @GetMapping("/getallexchanges")
    public ResponseEntity<?> getAllExch() {
        return ResponseEntity.ok(adminService.getAllExchanges());
    }

    @PostMapping("/updatexchange/id={id}")
    public ResponseEntity<?> updateEchangeById(@PathVariable("id") Long id, @RequestBody StockExchange stockExchange) {
        if (adminService.findExchangeById(id).isPresent()) {
            StockExchange stockExchange1 = adminService.updateExchangeById(id, stockExchange);
            if (stockExchange1 != null) {
                return ResponseEntity.ok(stockExchange1);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("company could not be updated");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("company id doesnt exists");
    }


}
