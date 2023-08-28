package com.esop.Esop_management.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class EmpDto {
	
	private int eid;
	private String fname;
	private String lname;

	private String email;
	private String password;
	private long mobile;
	private String address;

	private Date joiningDate;

	private int esop;

	private String department;

	private int granted;
	private int exercise;

	private String status;
	private double price;
	private CompanyDto company;

	private VestingPlanDto vestingPlan;
	
}
