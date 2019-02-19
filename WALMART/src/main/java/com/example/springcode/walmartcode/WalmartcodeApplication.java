package com.example.springcode.walmartcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import java.util.List;

@SpringBootApplication
public class WalmartcodeApplication{
	
	private OrderDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(WalmartcodeApplication.class, args);
	}
	
	

}
