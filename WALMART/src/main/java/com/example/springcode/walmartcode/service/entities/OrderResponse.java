package com.example.springcode.walmartcode.service.entities;

import java.util.List;

import com.example.springcode.walmartcode.entity.OrderEntity;

public class OrderResponse {
	
	
	private List<OrderEntity> orders;

	public List<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}

	
	

}
