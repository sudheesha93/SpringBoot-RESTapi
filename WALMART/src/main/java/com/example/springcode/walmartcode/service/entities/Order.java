package com.example.springcode.walmartcode.service.entities;

import java.io.Serializable;
import java.util.Date;

import com.example.springcode.walmartcode.entity.OrderStatus;
import com.example.springcode.walmartcode.entity.Supplier;

public class Order implements Serializable {
	
	
	
	private int id;
	
	
	private Date orderDate;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	public OrderStatus getStatus() {
		return status;
	}


	public void setStatus(OrderStatus status) {
		this.status = status;
	}


	private double amount;
	
	
	private Supplier supplier; 
	
	
	private OrderStatus status;

}
