package com.gabrielrosenbach.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielrosenbach.course.entities.Order;
import com.gabrielrosenbach.course.entities.User;
import com.gabrielrosenbach.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		
		List<Order> listOrders = orderService.findAll();
		
		return ResponseEntity.ok().body(listOrders);
	}
	
	@GetMapping(value = "/{code}")
	public ResponseEntity<Order> findById(@PathVariable Long code) {
		
		Order order = orderService.findById(code);
		
		return ResponseEntity.ok().body(order);
	}
}
