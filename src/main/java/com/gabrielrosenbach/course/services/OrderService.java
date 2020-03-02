package com.gabrielrosenbach.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielrosenbach.course.entities.Order;
import com.gabrielrosenbach.course.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository userRepository;

	public List<Order> findAll() {

		return userRepository.findAll();
	}
	
	public Order findById(Long code) {
		
		Optional<Order> order = userRepository.findById(code);
		
		return order.get();
	}
 }
