package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import com.example.demo.entities.Order;



@Entity
public class Customer
{
	 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(Long id, String name, List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.orders = orders;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", orders=" + orders + "]";
	}
	  
}
