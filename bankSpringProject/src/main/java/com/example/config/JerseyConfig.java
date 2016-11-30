package com.example.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.example.customer.CustomerService;

@Configuration
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(CustomerService.class);
	}
}
