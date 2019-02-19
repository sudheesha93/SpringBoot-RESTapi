package com.example.springcode.walmartcode;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {
	
	
	private StudentDAO dao;
	
	@Autowired
	public Controller(StudentDAO dao) {
		super();
		this.dao = dao;
	}

	// getting the studnet list
	@GetMapping("/studentlist")
	public List<Student> getAllStudents(){
		return dao.getAllStudents();
		
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
	
	
	@PostMapping("/supp/{id}")
	public void createOrder(@PathVariable(value="id") int suppId, 
			@RequestBody OrderEntity order) {
		dao.createOrder(suppId, order);
		
	}

	@PutMapping("/order/{id}")
	public int updateOrder(@PathVariable(value="id") int ordId) {	
		return dao.updateOrder(ordId);
	}
	
	@PutMapping
	public void saveOrUpdate(@RequestBody OrderItemEntity item) {
		dao.saveOrUpdate(item);
	}
}
