package com.esop.Esop_management.controller;

import java.util.List;

import com.esop.Esop_management.payload.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.esop.Esop_management.payload.CompanyDto;
import com.esop.Esop_management.response.ResponseHandler;
import com.esop.Esop_management.services.CompanyService;

import lombok.val;


@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;

	@CrossOrigin(origins = "*")
	@PostMapping("/register")
    public ResponseEntity<Object> create(@val @RequestBody CompanyDto companyDto){
		CompanyDto createCompanyDto = this.companyService.create(companyDto);
		
        return ResponseHandler.responseBuilder("Account created successfully",HttpStatus.OK,createCompanyDto);
        //return new ResponseEntity<>(createCompanyDto, HttpStatus.CREATED);
    }

    // post - updateuser
	@CrossOrigin(origins = "*")
    @PutMapping("/{comId}")
    public ResponseEntity<Object> update(@val @RequestBody CompanyDto companyDto, @PathVariable("comId") Integer comId){
        CompanyDto updatedUser = this.companyService.update(companyDto, comId);
		return ResponseHandler.responseBuilder("Profile updated successfully",HttpStatus.OK,updatedUser);
        //return new ResponseEntity<>(updatedUser,HttpStatus.ACCEPTED);
    }

	@CrossOrigin(origins = "*")
	@DeleteMapping("/{cId}")
	public ApiResponse deleteCompany(@PathVariable("cId") Integer cId){
		this.companyService.deleteCompany(cId);
		return new ApiResponse("Deleted Successfully",true);
	}
	//GET - user get

	@CrossOrigin(origins = "*")
	@GetMapping("/")
	public ResponseEntity<List<CompanyDto>> getAllCompany(){
		return ResponseEntity.ok(this.companyService.getAllCompany());
		
	}
	//GET - user get
	@CrossOrigin(origins = "*")
	@GetMapping("/{comId}")
	public ResponseEntity<CompanyDto> getCompanyById(@PathVariable Integer comId){
		return ResponseEntity.ok(this.companyService.getCompanyById(comId));
	}
}
