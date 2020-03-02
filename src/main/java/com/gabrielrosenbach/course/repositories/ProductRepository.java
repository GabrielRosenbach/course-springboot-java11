package com.gabrielrosenbach.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielrosenbach.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
