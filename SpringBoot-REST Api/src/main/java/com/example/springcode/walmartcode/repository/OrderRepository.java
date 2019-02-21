package com.example.springcode.walmartcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.springcode.walmartcode.entity.OrderEntity;


@RepositoryRestResource(path="members")
public interface OrderRepository extends JpaRepository<OrderEntity,Integer>{

	
	
	
}
