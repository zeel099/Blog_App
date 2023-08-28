package com.esop.Esop_management.controller;


import com.esop.Esop_management.payload.VestingPlanDto;
import com.esop.Esop_management.response.ResponseHandler;
import com.esop.Esop_management.services.VestingPlanService;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.esop.Esop_management.response.ResponseHandler.responseBuilder;

@RestController
@RequestMapping("/vplan")
public class VestingPlanController {

    @Autowired
    private VestingPlanService vestingPlanService;

    @Autowired
    private ModelMapper modelMapper;

    //@CrossOrigin(origins = "https://turbo-space-umbrella-5prwv9q494rfvvq4-3001.app.github.dev")
    @CrossOrigin(origins = "*")
    @PostMapping("/company/{cId}/plans")
    public ResponseEntity<Object> createPlan(@val @RequestBody VestingPlanDto vestingPlanDto,@PathVariable("cId") Integer cId){
        VestingPlanDto createdvestingPlan = this.vestingPlanService.createPlan(vestingPlanDto,cId);

        return ResponseHandler.responseBuilder("Plan added successfully",HttpStatus.OK,createdvestingPlan);
        //return new ResponseEntity<VestingPlanDto>(createdvestingPlan, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/update/{pId}")
    public ResponseEntity<Object> updatePlan(@val @RequestBody VestingPlanDto vestingPlanDto, @PathVariable("pId") Integer pId){
        VestingPlanDto updatedPlan = this.vestingPlanService.updatePlan(vestingPlanDto, pId);
        return responseBuilder("Plan updated successfully", HttpStatus.OK,updatedPlan);
        //return new ResponseEntity<>(updatedUser,HttpStatus.ACCEPTED);
    }

//    @DeleteMapping("/{pId}")
//    public ApiResponse deletePlan(@PathVariable("pId") Integer pId){
//        this.vestingPlanService.deletePlan(pId);
//        return new ApiResponse("Deleted successfully",true);
//    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{pId}")
    public ResponseEntity<Object> deletePlan(@PathVariable("pId") Integer pId){
        VestingPlanDto deletedEmp = this.vestingPlanService.deletePlan(pId);
        return responseBuilder("Deleted successfully",HttpStatus.OK,deletedEmp);
    }

//    @GetMapping("/")
//    public ResponseEntity<List<VestingPlanDto>> getAllPlans(){
//        return ResponseEntity.ok(this.vestingPlanService.getAllPlans());
//    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{pId}")
    public ResponseEntity<VestingPlanDto> getPlanById(@PathVariable Integer pId){

        //return ResponseHandler.responseBuilder("get paln",HttpStatus.OK,this.vestingPlanService.getPlanById(pId));
        return ResponseEntity.ok(this.vestingPlanService.getPlanById(pId));
    }

    //@CrossOrigin(origins = "*")
    @GetMapping("/company/{cId}/plans")
    public ResponseEntity<Object> getPlanByCompany(@PathVariable Integer cId){

        List<VestingPlanDto>plans = this.vestingPlanService.getPlanByCompany(cId);
        ResponseEntity<List<VestingPlanDto>> listResponseEntity = new ResponseEntity<>(plans, HttpStatus.OK);
        //VestingPlanDto updatedPlan = this.vestingPlanService.updatePlan(vestingPlanDto, pId);

        //return listResponseEntity;
//        return new ResponseEntity<>(plans, HttpStatus.OK);
        //this.modelMapper.map(listResponseEntity,EmpDto.class)
        return ResponseHandler.responseBuilder("get plan",HttpStatus.OK,plans);

        //return new ResponseEntity<List<VestingPlanDto>>(plans,HttpStatus.OK);
    }

}
