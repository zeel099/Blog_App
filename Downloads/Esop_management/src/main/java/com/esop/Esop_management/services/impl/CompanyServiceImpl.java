package com.esop.Esop_management.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.payload.CompanyDto;
import com.esop.Esop_management.repositories.CompanyRepo;
import com.esop.Esop_management.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepo companyRepo;
	
	@Override
	public CompanyDto create(CompanyDto companyDto) {
		Company company = this.dtoToCompany(companyDto);
        Company savedUser = this.companyRepo.save(company);
        return this.companyToDto(savedUser);
	}

	@Override
	public CompanyDto update(CompanyDto companyDto, Integer comId) {
		
		Company company = this.companyRepo.findById(comId).orElseThrow();

		company.setAddress(companyDto.getAddress());
		company.setCeo(companyDto.getCeo());
		company.setCname(companyDto.getCname());
		company.setEmail(companyDto.getEmail());
		company.setEsop(companyDto.getEsop());
		company.setFunding(companyDto.getFunding());
		company.setMobile(companyDto.getMobile());
		company.setValuation(companyDto.getValuation());
		company.setPassword(companyDto.getPassword());
		company.setEmail(companyDto.getEmail());
		company.setPrice(companyDto.getPrice());
		Company updatedCompany = this.companyRepo.save(company);
		CompanyDto companyDto1 = this.companyToDto(updatedCompany);
		this.companyToDto(updatedCompany);
		
		return companyDto1;
	}
	@Override
	public CompanyDto getCompanyById(Integer comId) {
		// TODO Auto-generated method stub
		Company company = this.companyRepo.findById(comId).
				orElseThrow();
		
		return this.companyToDto(company);
	}

	@Override
	public List<CompanyDto> getAllCompany() {
		// TODO Auto-generated method stub
		
		List<Company> users = this.companyRepo.findAll();
		
		List<CompanyDto> userDtos = users.stream().map(company->this.companyToDto(company)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteCompany(Integer comId) {
		// TODO Auto-generated method stub
		Company company = this.companyRepo.findById(comId).
				orElseThrow();
		this.companyRepo.delete(company);

	}
	public Company dtoToCompany(CompanyDto companyDto) {
		
		Company company = new Company();
		
		company.setCid(companyDto.getCid());
		company.setAddress(companyDto.getAddress());
		company.setCeo(companyDto.getCeo());
		company.setCname(companyDto.getCname());
		company.setEmail(companyDto.getEmail());
		company.setEsop(companyDto.getEsop());
		company.setFunding(companyDto.getFunding());
		company.setMobile(companyDto.getMobile());
		company.setValuation(companyDto.getValuation());
		company.setPassword(companyDto.getPassword());
		company.setEmail(companyDto.getEmail());
		company.setPrice(companyDto.getPrice());
		return company;
	}
	public CompanyDto companyToDto(Company company) {
		
		CompanyDto companyDto = new CompanyDto();
		companyDto.setCid(company.getCid());
		companyDto.setAddress(company.getAddress());
		companyDto.setCeo(company.getCeo());
		companyDto.setCname(company.getCname());
		companyDto.setEmail(company.getEmail());
		companyDto.setEsop(company.getEsop());
		companyDto.setFunding(company.getFunding());
		companyDto.setMobile(company.getMobile());
		companyDto.setPassword(company.getPassword());
		companyDto.setValuation(company.getValuation());
		companyDto.setPrice(company.getPrice());
		
		return companyDto;
	}
	
}
