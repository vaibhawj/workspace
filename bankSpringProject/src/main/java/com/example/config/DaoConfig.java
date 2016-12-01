package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.dao.CustomerDao;
import com.example.dao.impl.CustomerDaoImpl;

@Configuration
public class DaoConfig {

	@Bean
	public CustomerDao customerDao() {
		return new CustomerDaoImpl();
	}

}
