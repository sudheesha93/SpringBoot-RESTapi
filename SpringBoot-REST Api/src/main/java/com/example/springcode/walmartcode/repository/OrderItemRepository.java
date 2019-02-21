package com.example.springcode.walmartcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.springcode.walmartcode.entity.OrderItemEntity;


@RepositoryRestResource(path="orderitems")
public interface OrderItemRepository extends JpaRepository<OrderItemEntity,Integer>{

}
