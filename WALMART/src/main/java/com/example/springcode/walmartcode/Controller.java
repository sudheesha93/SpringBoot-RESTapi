package com.example.springcode.walmartcode;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	@GetMapping("/supplist")
	public List<Supplier> getAllSupplier(){
		return dao.getAllSupplier(); 
		
	}
	
	// getting the order list
	@GetMapping("/orderlist")
	public List<OrderEntity> getAllOrders(){
		return dao.getAllOrders(); 
		
	}
	
	// getting the item list
	@GetMapping("/itemlist")
	public List<OrderItemEntity> getAllItems(){
		return dao.getAllItems(); 
		
	}
	
	// Creating an order for the supplier
	@RequestMapping(value = "/supp/{id}", method = RequestMethod.POST)
	public void createOrder(@PathVariable final int id, 
			@RequestBody OrderEntity order) {
		dao.createOrder(id, order);
		
	}

	// updating the status of the order
	@PutMapping("/order/{id}")
	public void updateOrder(@PathVariable final int id) {	
		dao.updateOrder(id);
	}
	
	// Add/modify the item for the open orders
	@PutMapping("/item")
	public void saveOrUpdate(@RequestBody OrderItemEntity item) {
		dao.saveOrUpdate(item);
	}
	
	
}
