package com.example.springcode.walmartcode.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="order_items")
public class OrderItemEntity {
	
	@Id
	@Column(name="item_id")
	private int itemid;
	
	@ManyToOne()
	@ForeignKey(name="orderId")
	private OrderEntity orderId;
	
	@Column(name="amount")
	private double amount;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	public ItemStatus status;
	
	
	public OrderItemEntity() {
		
	}
	public OrderItemEntity(int itemid, OrderEntity orderId, double amount, ItemStatus status) {
		super();
		this.itemid = itemid;
		this.orderId = orderId;
		this.amount = amount;
		this.status = status;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public OrderEntity getOrderId() {
		return orderId;
	}
	public void setOrderId(OrderEntity orderId) {
		this.orderId = orderId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public ItemStatus getStatus() {
		return status;
	}
	public void setStatus(ItemStatus status) {
		this.status = status;
	}
	
	
	
	
	

}
