package com.example.springcode.walmartcode;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="supplier")
public class Supplier {
	
	@Id
	@Column(name="suuplier_id")
	private int id;
	
	@Column(name="suuplier_name")
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name="active_IND")
	private ACTIVESTATUS status;
	
	enum ACTIVESTATUS{Yes, No;}
	
	
	
	public Supplier() {
		
	}

	public Supplier(int id, String name, ACTIVESTATUS status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ACTIVESTATUS getStatus() {
		return status;
	}

	public void setStatus(ACTIVESTATUS status) {
		this.status = status;
	}
	
	
	}
	


