package com.example.stocknew.services;

import com.example.stocknew.models.Company;
import com.example.stocknew.models.CompanyDTO;
import com.example.stocknew.models.Sector;
import com.example.stocknew.models.StockExchange;
import com.example.stocknew.repos.CompanyRepository;
import com.example.stocknew.repos.SectorRepository;
import com.example.stocknew.repos.StockExchangeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private final CompanyRepository companyRepository;
    private final SectorRepository sectorRepository;
    private final StockExchangeRepository stockExchangeRepository;
    public AdminService(CompanyRepository companyRepository, SectorRepository sectorRepository, StockExchangeRepository stockExchangeRepository) {
        this.companyRepository = companyRepository;
        this.sectorRepository = sectorRepository;
        this.stockExchangeRepository = stockExchangeRepository;
    }
    public Company addCompany(CompanyDTO companyDTO){
        if (companyRepository.existsByName(companyDTO.getName())){
            return null;
        }
        Company company=new Company();
        company.setName(companyDTO.getName());
        company.setCode(companyDTO.getCode());
        company.setSector(sectorRepository.findById(companyDTO.getSectorId()).get());
        return companyRepository.save(company);
    }
    public List<Company> getAll(){
        return companyRepository.findAll();
    }
    public List<Sector> getAllSectors(){
        return sectorRepository.findAll();
    }
    public Optional <Company> findById(Long id){
        return companyRepository.findById(id);
    }
    public Company findCompanyByCode(Long code){
        return companyRepository.findCompanyByCode(code);
    }
    public void deleteCompanyById(Long id){
        companyRepository.deleteById(id);
    }
    public void deleteCompanyByCode(Long code){
        companyRepository.deleteCompanyByCode(code);
    }
    public Company updateCompanyById(Long id,CompanyDTO companyDTO){
        Company company=companyRepository.getOne(id);
        company.setName(companyDTO.getName());
        company.setCode(companyDTO.getCode());
        company.setSector(sectorRepository.findById(companyDTO.getSectorId()).get());
        company.setCeo(companyDTO.getCeo());
        company.setBrief(companyDTO.getBrief());
        company.setTurnover(companyDTO.getTurnover());
        return companyRepository.save(company);
}
    public List<StockExchange> getAllExchanges(){
        return stockExchangeRepository.findAll();
    }
    public Optional <StockExchange> findExchangeById (Long id){
        return stockExchangeRepository.findById(id);
    }
    public StockExchange updateExchangeById(Long id,StockExchange stockExchange)
    {
        StockExchange stockExchange1=stockExchangeRepository.getOne(id);
        stockExchange1.setName(stockExchange.getName());
        stockExchange1.setBrief(stockExchange.getBrief());
        stockExchange1.setStreet(stockExchange.getStreet());
        stockExchange1.setState(stockExchange.getState());
        stockExchange1.setCountry(stockExchange.getCountry());
        stockExchange1.setRemarks(stockExchange.getRemarks());
       return stockExchangeRepository.save(stockExchange1);
    }
}
