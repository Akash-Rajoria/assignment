package com.example.demo.service;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Order;

import java.util.List;

public interface CustomerService 
{
    List<Customer> getCustomersWithoutOrders();

    Customer saveCustomerWithOrder(Customer customer);
}
