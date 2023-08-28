package com.esop.Esop_management.services;

import com.esop.Esop_management.entity.Emp;
import com.esop.Esop_management.payload.CompanyDto;
import com.esop.Esop_management.payload.EmpDto;

import java.util.List;


public interface EmpService {
	
	EmpDto createEmp(EmpDto empDto,Integer pId,Integer cId);
    EmpDto updateEmp(EmpDto empDto, Integer empId);

    EmpDto getEmpById(Integer empId);

    List<EmpDto>getEmpByCompany(Integer cId);
    List<EmpDto>getEmpByPlan(Integer pId);
    List<EmpDto> getAllEmployee();

    EmpDto deleteEmployee(Integer empId);

    List<EmpDto> searchEmp(String keyword);
}
