package com.esop.Esop_management.services.impl;

import com.esop.Esop_management.controller.EmpController;
import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.entity.VestingPlan;
import com.esop.Esop_management.exceptions.ResourceNotFoundException;
import com.esop.Esop_management.payload.CompanyDto;
import com.esop.Esop_management.payload.VestingPlanDto;
import com.esop.Esop_management.repositories.CompanyRepo;
import com.esop.Esop_management.repositories.VestingPlanRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esop.Esop_management.entity.Emp;
import com.esop.Esop_management.payload.EmpDto;
import com.esop.Esop_management.repositories.EmpRepo;
import com.esop.Esop_management.services.EmpService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpRepo empRepo;

	@Autowired
	private VestingPlanRepo vestingPlanRepo;

	@Autowired
	private CompanyRepo companyRepo;

	@Autowired
	private ModelMapper modelMapper;


	@Override
	public EmpDto createEmp(EmpDto empDto,Integer pId,Integer cId) {

		VestingPlan vestingPlan = this.vestingPlanRepo.findById(pId)
				.orElseThrow(()->new ResourceNotFoundException("VestingPlan","pId",pId));
		Company company = this.companyRepo.findById(cId)
				.orElseThrow(()->new ResourceNotFoundException("Company","cId",cId));

		Emp emp = this.modelMapper.map(empDto, Emp.class);
		emp.setVestingPlan(vestingPlan);
		emp.setCompany(company);
		emp.setStatus("Active");
		Emp savedEmp = this.empRepo.save(emp);
		
		return this.modelMapper.map(savedEmp,EmpDto.class);
	}

	@Override
	public EmpDto updateEmp(EmpDto empDto, Integer empId) {
		Emp emp = this.empRepo.findById(empId).orElseThrow();

		emp.setEmail(empDto.getEmail());
		emp.setPassword(empDto.getPassword());
		emp.setAddress(empDto.getAddress());
		emp.setFname(empDto.getFname());
		emp.setEsop(empDto.getEsop());
		emp.setLname(empDto.getLname());
		emp.setMobile(empDto.getMobile());
		emp.setJoiningdate(empDto.getJoiningDate());
		emp.setExercise(empDto.getExercise());
		emp.setGranted(empDto.getGranted());
		emp.setDepartment(empDto.getDepartment());
		emp.setStatus(empDto.getStatus());

		Emp updatedEmp = this.empRepo.save(emp);
		
		return this.modelMapper.map(updatedEmp,EmpDto.class);
		
	}

	@Override
	public EmpDto getEmpById(Integer empId) {
		// TODO Auto-generated method stub
		Emp emp = this.empRepo.findById(empId).
				orElseThrow(()->new ResourceNotFoundException("Emp","empId",empId));

		return this.modelMapper.map(emp,EmpDto.class);
	}

	@Override
	public List<EmpDto> getEmpByCompany(Integer cId) {

		Company company= this.companyRepo.findById(cId).orElseThrow(()->new ResourceNotFoundException("Company","companyId",cId));

		List<Emp>emp = this.empRepo.findByCompany(company);
		List<EmpDto>empDtos = emp.stream().map((plan)->this.modelMapper.map(plan,EmpDto.class)).collect(Collectors.toList());

		return empDtos;
	}

	@Override
	public List<EmpDto> getEmpByPlan(Integer pId) {
		VestingPlan vestingPlan = this.vestingPlanRepo.findById(pId)
				.orElseThrow(()->new ResourceNotFoundException("VestingPlan","pId",pId));
		List<Emp>emp = this.empRepo.findByVestingPlan(vestingPlan);
		List<EmpDto>empDtos = emp.stream().map((employee)->this.modelMapper.map(employee,EmpDto.class)).collect(Collectors.toList());
		return empDtos;
	}

	@Override
	public List<EmpDto> getAllEmployee() {
		// TODO Auto-generated method stub

		List<Emp> employees = this.empRepo.findAll();

		List<EmpDto> userDtos = employees.stream().map(emp->this.modelMapper.map(emp,EmpDto.class)).collect(Collectors.toList());
		return userDtos;
		//return null;
	}

	@Override
	public EmpDto deleteEmployee(Integer empId) {

		Emp emp = this.empRepo.findById(empId).
				orElseThrow(()->new ResourceNotFoundException("Emp","empId",empId));
		this.empRepo.delete(emp);
		return this.modelMapper.map(emp,EmpDto.class);

	}

	@Override
	public List<EmpDto> searchEmp(String keyword) {
		List<Emp>empList = this.empRepo.searchByEmail("%"+keyword+"%");
		List<EmpDto>empDtos = empList.stream().map((emp)->this.modelMapper.map(emp,EmpDto.class)).collect((Collectors.toList()) );
		return empDtos;
	}

}
