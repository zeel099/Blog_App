package com.esop.Esop_management.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esop.Esop_management.entity.User;
import com.esop.Esop_management.payload.UserDto;
import com.esop.Esop_management.repositories.UserRepo;
import com.esop.Esop_management.services.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserRepo userRepo;
    
   
    @Override
    public UserDto create(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

   
    @Override
    public UserDto update(UserDto userDto, Integer userId) {

    	User user = this.userRepo.findById(userId).
				orElseThrow();
		
//		user.setCid(userDto.getCid());
    	//user.setUid(userDto.getUid());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
//		user.setAddress(userDto.getAddress());
//		user.setCeo(userDto.getCeo());
//		user.setCname(userDto.getCname());
//		user.setEsop(userDto.getEsop());
//		user.setValuation(userDto.getValuation());
//		user.setFunding(userDto.getFunding());
//		user.setMobile(userDto.getMobile());
		
		
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);
		this.userToDto(updatedUser);
		
		return userDto1;
    	
    }

     public User dtoToUser(UserDto userDto){
    	
        User user =new User();
       
        
		user.setUid(userDto.getUid());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		
		
    	//User user = this.modelMapper.map(userDto,User.class);

        return user;
    }
    public UserDto userToDto(User user){
        UserDto userDto = new UserDto();
        
        userDto.setUid(user.getUid());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());

        return userDto;
    }
}
