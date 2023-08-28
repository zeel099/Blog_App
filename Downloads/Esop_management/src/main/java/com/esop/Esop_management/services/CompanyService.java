package com.esop.Esop_management.services;

import java.util.List;

import com.esop.Esop_management.payload.CompanyDto;

public interface CompanyService {

	CompanyDto create(CompanyDto companyDto);
	CompanyDto update(CompanyDto companyDto,Integer comId);
	
	CompanyDto getCompanyById(Integer comId);
	
	List<CompanyDto>getAllCompany();
	
	 void deleteCompany(Integer comId);
}
