package com.esop.Esop_management;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EsopManagementApplication implements CommandLineRunner{

//	@Autowired
//	private PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(EsopManagementApplication.class, args);
	}

	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	    System.out.println("parth@72784");
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
//	@Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
//        return builder.getAuthenticationManager();
//    }
	
	
}
