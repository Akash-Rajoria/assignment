package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Order;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService 
{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Customer> getCustomersWithoutOrders() 
    {
        List<Customer> allCustomers = customerRepository.findAll();
        List<Customer> customersWithOrders = orderRepository.findDistinctByCustomerIsNotNull()
                .stream()
                .map(Order::getCustomer)
                .collect(Collectors.toList());
        allCustomers.removeAll(customersWithOrders);
        return allCustomers;
    }

    @Override
    @Transactional
    public Customer saveCustomerWithOrder(Customer customer) 
    {
        List<Order> orders = customer.getOrders();
        orders.forEach(order -> order.setCustomer(customer));
        List<Order> savedOrders = orderRepository.saveAll(orders);
        customer.getOrders().addAll(savedOrders);
        return customerRepository.save(customer);
    }
}
