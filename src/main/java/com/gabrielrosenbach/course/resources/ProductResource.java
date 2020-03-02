package com.gabrielrosenbach.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielrosenbach.course.entities.Product;
import com.gabrielrosenbach.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		
		List<Product> listProducts = productService.findAll();
		
		return ResponseEntity.ok().body(listProducts);
	}
	
	@GetMapping(value = "/{code}")
	public ResponseEntity<Product> findById(@PathVariable Long code) {
		
		Product product = productService.findById(code);
		
		return ResponseEntity.ok().body(product);
	}
}
