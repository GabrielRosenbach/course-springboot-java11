package com.gabrielrosenbach.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielrosenbach.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
