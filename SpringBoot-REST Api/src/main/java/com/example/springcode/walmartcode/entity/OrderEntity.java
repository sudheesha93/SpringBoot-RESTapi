package com.example.springcode.walmartcode.entity;


import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="order_table")
public class OrderEntity {
	
	@Id
	@Column(name="order_id")
	private int id;
	
	@Column(name="order_date")
	private Date orderDate;
	
	@Column(name="order_amount")
	private double amount;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="suuplier_id")
	private Supplier supplier; 
	
	@Enumerated(EnumType.STRING)
	@Column(name="status",length=8)
	private OrderStatus status;
	
	
		
	
	public OrderEntity() {
		
	}

	public OrderEntity(int id, Date orderDate, double amount, Supplier supplier, OrderStatus status) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.amount = amount;
		this.supplier = supplier;
		this.status = status;
	}

	
	
	

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
	
	

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", orderDate=" + orderDate + ", amount=" + amount + ", supplier=" + supplier
				+ ", status=" + status + "]";
	}
	
	
	

}
