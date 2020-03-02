package com.gabrielrosenbach.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielrosenbach.course.entities.Product;
import com.gabrielrosenbach.course.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {

		return productRepository.findAll();
	}
	
	public Product findById(Long code) {
		
		Optional<Product> product = productRepository.findById(code);
		
		return product.get();
	}
 }
