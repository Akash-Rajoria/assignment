package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//Order.java
import jakarta.persistence.Table;
 
@Entity
@Table(name = "customer_order")
public class Order 
{

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	 private String productname;
	 
	 @ManyToOne
	 @JoinColumn(name = "customer_id")
	 @JsonIgnore
	 private Customer customer;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order(Long id, String productname, Customer customer) {
		super();
		this.id = id;
		this.productname = productname;
		this.customer = customer;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getProductname() {
		return productname;
	}
	
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", productname=" + productname + ", customer=" + customer + "]";
	}

}
