package com.esop.Esop_management.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esop.Esop_management.entity.User;
import com.esop.Esop_management.payload.UserDto;

public interface UserRepo extends JpaRepository<User,Integer>{
	
	Optional<User>findByEmail(String email);
	void save(UserDto user);

}
