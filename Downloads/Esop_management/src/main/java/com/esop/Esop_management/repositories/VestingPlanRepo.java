package com.esop.Esop_management.repositories;

import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.entity.VestingPlan;
import com.esop.Esop_management.payload.CompanyDto;
import com.esop.Esop_management.payload.VestingPlanDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VestingPlanRepo extends JpaRepository<VestingPlan,Integer> {
    //Optional<VestingPlan>findById(Integer pid);
    List<VestingPlan> findByCompany(Company company);
    Optional<VestingPlan>findById(Integer pid);
    //void save(VestingPlanDto vestingPlanDto);

}
