package com.gabrielrosenbach.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielrosenbach.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
