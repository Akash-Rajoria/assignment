package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Order;
import com.example.demo.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController
{

	 @Autowired
	 private CustomerService customerService;
	
	 @GetMapping("/without-orders")
	 public List<Customer> getCustomersWithoutOrders()
	 {
	     return customerService.getCustomersWithoutOrders();
	 }
	 
	 @PostMapping("/save-customer-with-order")
	 public Customer saveCustomerWithOrder(@RequestBody Customer customer)
	 {
	     return customerService.saveCustomerWithOrder(customer);
	 }
}
