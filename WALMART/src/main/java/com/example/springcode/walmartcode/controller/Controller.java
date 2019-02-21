package com.example.springcode.walmartcode.controller;

import java.util.List;

import javax.ws.rs.client.ResponseProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.example.springcode.walmartcode.service.entities.Order;
import com.example.springcode.walmartcode.service.entities.OrderResponse;

@RestController
@RequestMapping("/api")
public class Controller {
	
	
	private OrderDAO dao;
	
	@Autowired
	public Controller(OrderDAO dao) {
		super();
		this.dao = dao;
	}
	
	
	
	
	
	@RequestMapping("/order/{id}")
	public void getOrderById(@PathVariable final int id) throws DataNotFoundException{
		dao.getOrderById(id);
	}
	
	
	// getting the supplier list
	@GetMapping("/supplist")
	public List<Supplier> getAllSupplier(){
		return dao.getAllSupplier();
		
			
	}
	
	// getting the order list
	// @GetMapping("/orderlist")
	//@ResponseBody
	//@ResponseStatus( HttpStatus.OK 
	//public List<OrderEntity> getAllOrders(){
	
//		return dao.getAllOrders()

	
	
	
	@GetMapping("/orders")
	public ResponseEntity<OrderResponse> getAllOrder(){
		
		
		OrderResponse orderResponse = new OrderResponse();
				
		orderResponse.setOrders(dao.getAllOrders());
	
		ResponseEntity<OrderResponse> responseEntity = new ResponseEntity<OrderResponse>(orderResponse, HttpStatus.OK);
		
		return responseEntity;
	}
	
	
	// getting the item list
	@GetMapping("/itemlist")
	public List<OrderItemEntity> getAllItems() {
		return dao.getAllItems();
		

		
	}
	
	// Creating an order for the supplier
	@RequestMapping(value = "/supp/{id}", method = RequestMethod.POST)
	public void createOrder(@PathVariable final int id,@RequestBody OrderEntity order){
		dao.createOrder(id, order);
		
		
	}

	// updating the status of the order
	@PutMapping("/order/{id}")
	public void updateOrder(@PathVariable final int id) throws DataNotFoundException{	

			dao.updateOrder(id);
	
	
	}
	
	// Add/modify the item for the open orders
	@PutMapping("/item")
	public void saveOrUpdate(@RequestBody OrderItemEntity item){
		
			dao.saveOrUpdate(item);
	
}
	
	
	

}