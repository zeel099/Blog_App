package com.esop.Esop_management.services;



import com.esop.Esop_management.payload.UserDto;


public interface UserService {
	
	UserDto create(UserDto userDto);
    UserDto update(UserDto userDto, Integer userId);
}
