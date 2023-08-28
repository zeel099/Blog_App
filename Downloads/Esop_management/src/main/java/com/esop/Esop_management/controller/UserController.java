package com.esop.Esop_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.esop.Esop_management.payload.UserDto;
import com.esop.Esop_management.response.ResponseHandler;
import com.esop.Esop_management.services.UserService;

import lombok.val;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

    @CrossOrigin(origins = "https://turbo-space-umbrella-5prwv9q494rfvvq4-3001.app.github.dev")
    @PostMapping("/login")
    public ResponseEntity<Object> create(@val @RequestBody UserDto userDto){
        UserDto createUserDto = this.userService.create(userDto);
        
        return ResponseHandler.responseBuilder("Account created successfully",HttpStatus.OK,createUserDto);
        //return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    // post - updateuser
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> update(@val @RequestBody UserDto userDto, @PathVariable("userId") Integer userId){
        UserDto updateUser = this.userService.update(userDto, userId);
        return ResponseEntity.ok(updateUser);
    }

}
