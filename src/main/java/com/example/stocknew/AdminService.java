package com.example.stocknew;

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
     Optional <Company> company = companyRepository.findById(id);
     if (company.isPresent())
     {
         return company;
     }
     return null ;
    }
    public Company findCompanyByCode(Long code){
        Company company= companyRepository.findCompanyByCode(code);
        if (company!=null)
        {
            return company;
        }
        return null ;
    }
    public void deleteCompanyById(Long id){
        companyRepository.deleteById(id);
    }
    public void deleteCompanyByCode(Long code){
        companyRepository.deleteCompanyByCode(code);
    }
    public Company updateCompanyById(Long id,CompanyDTO companyDTO){
        companyRepository.deleteById(id);
        System.out.println("deleted");
    Company company=new Company();
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
        stockExchangeRepository.deleteById(id);
       return stockExchangeRepository.save(stockExchange);
    }
}
