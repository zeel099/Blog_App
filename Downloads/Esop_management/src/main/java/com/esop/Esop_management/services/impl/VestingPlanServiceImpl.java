package com.esop.Esop_management.services.impl;

import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.entity.VestingPlan;
import com.esop.Esop_management.exceptions.ResourceNotFoundException;
import com.esop.Esop_management.payload.CompanyDto;
import com.esop.Esop_management.payload.VestingPlanDto;
import com.esop.Esop_management.repositories.CompanyRepo;
import com.esop.Esop_management.repositories.VestingPlanRepo;
import com.esop.Esop_management.services.VestingPlanService;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class VestingPlanServiceImpl implements VestingPlanService{

    @Autowired
    private VestingPlanRepo vestingPlanRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public VestingPlanDto createPlan(VestingPlanDto vestingPlanDto,Integer cId) {

        Company company = this.companyRepo.findById(cId).orElseThrow(()-> new ResourceNotFoundException("Company","companyId",cId));

        VestingPlan vestingPlan = this.modelMapper.map(vestingPlanDto,VestingPlan.class);
        //VestingPlan vestingPlan = this.modelMapper.map(vestingPlanDto,VestingPlan.class);
        vestingPlan.setCompany(company);
        VestingPlan newPlan = this.vestingPlanRepo.save(vestingPlan);

        return this.modelMapper.map(newPlan,VestingPlanDto.class);
    }



//    @Override
//    public VestingPlanDto createPlan(VestingPlanDto vestingPlanDto,Integer cId) {
//
//        Company company = this.companyRepo.findById(cId).orElseThrow(()-> new ResourceNotFoundException("Company","Compnay id",cId));
//        VestingPlan vestingPlan = this.dtoToVestingPlan(vestingPlanDto);
//        vestingPlan.setCompany(company);
//
//        VestingPlan savedUser = this.vestingPlanRepo.save(vestingPlan);
//        return this.vestingPlanToDto(savedUser);
//    }

    @Override
    public VestingPlanDto updatePlan(VestingPlanDto vestingPlanDto, Integer pId) {

        VestingPlan vestingPlan = this.vestingPlanRepo.findById(pId).orElseThrow(()->new ResourceNotFoundException("VestingPlan","plan id",pId));

        vestingPlan.setVestingPeriod(vestingPlanDto.getVestingPeriod());
        vestingPlan.setCliffPeriod(vestingPlanDto.getCliffPeriod());
       // vestingPlan.setCid(vestingPlan.getCid());

        VestingPlan updatedPlan = this.vestingPlanRepo.save(vestingPlan);

       // VestingPlanDto planDto1 = this.vestingPlanToDto(updatedPlan);
        //this.vestingPlanToDto(updatedPlan);
        return this.modelMapper.map(updatedPlan,VestingPlanDto.class);
        //return planDto1;
    }
    @Override
    public VestingPlanDto getPlanById(Integer pId) {
            // TODO Auto-generated method stub
            VestingPlan vestingPlan = this.vestingPlanRepo.findById(pId).orElseThrow(()->new ResourceNotFoundException("vestingplan","pId",pId));

            return this.modelMapper.map(vestingPlan,VestingPlanDto.class);
    }

//    @Override
//    public List<VestingPlanDto> getAllPlans() {
//
//
//            List<VestingPlan> plans = this.vestingPlanRepo.findAll();
//
//            List<VestingPlanDto> planDtos = plans.stream().map((company)->this.map(company,VestingPlanDto.class)).collect(Collectors.toList());
//            return planDtos;
//        //return null;
//    }

    @Override
    public List<VestingPlanDto> getPlanByCompany(Integer cId) {
        //find all company id
        Company company= this.companyRepo.findById(cId).orElseThrow(()->new ResourceNotFoundException("Company","companyId",cId));

        //findcompany by id
        List<VestingPlan>plans = this.vestingPlanRepo.findByCompany(company);

        //convert plans into dto class
        //convert one by one plan into vetsingPlanDto
        List<VestingPlanDto>planDtos = plans.stream().map((plan)->this.modelMapper.map(plan,VestingPlanDto.class)).collect(Collectors.toList());

        return planDtos;
    }



    @Override
    public VestingPlanDto deletePlan(Integer pId) {
            // TODO Auto-generated method stub
            VestingPlan vestingPlan = this.vestingPlanRepo.findById(pId).orElseThrow(()->new ResourceNotFoundException("VestingPlan","pId",pId));
            this.vestingPlanRepo.delete(vestingPlan);

            return this.modelMapper.map(vestingPlan,VestingPlanDto.class);

    }
//    public VestingPlan dtoToVestingPlan(VestingPlanDto vestingPlanDto) {
//
//            VestingPlan vestingPlan = new VestingPlan();
//
//            vestingPlan.setPid(vestingPlanDto.getPid());
//            vestingPlan.setVestingPeriod(vestingPlanDto.getVestingPeriod());
//            vestingPlan.setCliffPeriod(vestingPlanDto.getCliffPeriod());
//            //vestingPlan.setCid(vestingPlanDto.getCid());
//
//
//            return vestingPlan;
//    }
//    public VestingPlanDto vestingPlanToDto(VestingPlan vestingPlan) {
//
//            VestingPlanDto vestingPlanDto = new VestingPlanDto();
//
//            vestingPlanDto.setPid(vestingPlan.getPid());
//            vestingPlanDto.setVestingPeriod(vestingPlan.getVestingPeriod());
//            vestingPlanDto.setCliffPeriod(vestingPlan.getCliffPeriod());
//            //vestingPlanDto.setCid(vestingPlan.getCid());
//
//            return vestingPlanDto;
//    }

}
