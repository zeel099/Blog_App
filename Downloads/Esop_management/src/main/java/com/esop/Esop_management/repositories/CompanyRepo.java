package com.esop.Esop_management.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.payload.CompanyDto;


public interface CompanyRepo extends JpaRepository<Company,Integer>{
	
	Optional<Company>findByEmail(String email);
	void save(CompanyDto company);
}
