package com.liveasy.Liveasy;

import org.modelmapper.ModelMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

@SpringBootTest
class LiveasyApplicationTests {

	@Test
	void contextLoads() {
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
