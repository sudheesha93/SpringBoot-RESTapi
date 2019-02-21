package com.example.springcode.walmartcode.controller;

import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import com.example.springcode.walmartcode.DAO.OrderDAO;
import com.example.springcode.walmartcode.entity.OrderEntity;
import com.example.springcode.walmartcode.entity.OrderItemEntity;
import com.example.springcode.walmartcode.entity.Supplier;
import com.example.springcode.walmartcode.exception.DataNotFoundException;


@RestController
@RequestMapping("/api")
public class Controller {
	
	
	private OrderDAO dao;
	
	@Autowired
	public Controller(OrderDAO dao) {
		super();
		this.dao = dao;
	}
	


	// getting the supplier list
	@GetMapping("/suppliers")
	public List<Supplier> getAllSupplier(){
		
		List<Supplier> list;
		
		try {
		list =dao.getAllSupplier();
			if(list.isEmpty()) {
				throw new DataNotFoundException("No Suppliers available in the database..!!");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new DataNotFoundException("500", e);
		}
		return list;	
		
			
	}
	
	//getting the order list
	@GetMapping("/orders")
	public List<OrderEntity> getAllOrders(){
		List<OrderEntity> list;
		
		try {
		list =dao.getAllOrders();
			if(list.isEmpty()) {
				throw new DataNotFoundException("No Orders available in the database..!!");
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataNotFoundException("500", e);
		}
		return list;
	}

	
	// getting the item list
	@GetMapping("/items")
	public List<OrderItemEntity> getAllItems() {
		
		List<OrderItemEntity> list;
		
		try {
		list =dao.getAllItems();
			if(list.isEmpty()) {
				throw new DataNotFoundException("No Items available in the database..!!");
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataNotFoundException("500", e);
		}
		return list;
		
	}
	
	// Creating an order for the supplier
	@RequestMapping(value = "/supplier/{id}", method = RequestMethod.POST)
	public void createOrder(@PathVariable final int id,@RequestBody OrderEntity order) {
		
		if(id<0) {
			throw new DataNotFoundException("Entered an INVALID Supplier ID");
			}
		
		try {
			dao.createOrder(id, order);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataNotFoundException("500", e);
		}
	}

	
	// updating the status of the order
	@PutMapping("/order/{id}")
	public void updateOrder(@PathVariable final int id){	

			if(id<0) {
				throw new DataNotFoundException("Entered an INVALID Order ID");
				}
			
			try {
				dao.updateOrder(id);
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new DataNotFoundException("500", e);
			}
	
	
	}
	
	// Add/modify the item for the open orders
	@PutMapping("/item")
	public void saveOrUpdate(@RequestBody OrderItemEntity item){
		
		if(item.getOrderId()==null) {
			throw new DataNotFoundException("Order Id for given Item is invalid");
		}
		try {
			dao.saveOrUpdate(item);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataNotFoundException("500", e);
		}
			
	
}
	
	
	

}