/* package com.example.springcode.walmartcode.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.springcode.walmartcode.DAO.OrderDAO;
import com.example.springcode.walmartcode.entity.OrderEntity;
import com.example.springcode.walmartcode.service.entities.Order;

public class OrderBusinessService {
	
	
	//@Autowired
	private OrderDAO orderDAO;
	
	public List<Order> getAllOrder(){
		
		List<Order> ordersList = new ArrayList<Order>();
		
		List<OrderEntity> orderEntityList =  orderDAO.getAllOrders();
		
		if(orderEntityList != null && !orderEntityList.isEmpty()) {
			
			for(OrderEntity orderEntity: orderEntityList) {
				//Order 
			}
			
			
		}
		return 
	}
	
	

}*/
