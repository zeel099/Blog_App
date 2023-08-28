package com.esop.Esop_management.services;

import com.esop.Esop_management.payload.CompanyDto;
import com.esop.Esop_management.payload.VestingPlanDto;

import java.util.List;

public interface VestingPlanService {

    VestingPlanDto createPlan(VestingPlanDto vestingPlanDto,Integer cId);

    VestingPlanDto updatePlan(VestingPlanDto vestingPlanDto,Integer pid);

    VestingPlanDto getPlanById(Integer pid);
    List<VestingPlanDto>getPlanByCompany(Integer cId);
    //List<VestingPlanDto> getAllPlans();

    VestingPlanDto deletePlan(Integer pid);

}
