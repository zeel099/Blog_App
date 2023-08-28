package com.esop.Esop_management.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.repositories.CompanyRepo;
@Service
public class CustomUserDetailService {

//	@Autowired
//	private CompanyRepo companyRepo;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		//loading user from database by username
//		Company company = this.companyRepo.findByEmail(username)
//				.orElseThrow(()->new RuntimeException("Invalid usename or password"));
//		return company;
//	}

}
