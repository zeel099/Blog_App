package com.esop.Esop_management.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CompanyDto {

	private int cid;
	private String cname;
	private String ceo;
	private long funding;
	private long valuation;
	private long esop;
	private long mobile;
	private double price;
	private String address;
	private String email;
	private String password;
	
}
