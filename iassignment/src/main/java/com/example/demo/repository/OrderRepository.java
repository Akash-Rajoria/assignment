package com.example.demo.repository;

import java.util.List;
import com.example.demo.entities.Order;

//OrderRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> 
{
    List<Order> findDistinctByCustomerIsNotNull();
}