package com.esop.Esop_management.repositories;

import java.util.List;
import java.util.Optional;

import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.entity.VestingPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import com.esop.Esop_management.entity.Emp;
import com.esop.Esop_management.payload.EmpDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmpRepo extends JpaRepository<Emp,Integer>{
	
	Optional<Emp>findById(Integer empId);
	List<Emp> findByCompany(Company company);
	List<Emp>findByVestingPlan(VestingPlan vestingPlan);

	//List<Emp>findByEmailContaining(String email);
	@Query("select e from Emp e where e.email like :key")
	List<Emp>searchByEmail(@Param("key") String email);
	void save(EmpDto emp);
	

}
