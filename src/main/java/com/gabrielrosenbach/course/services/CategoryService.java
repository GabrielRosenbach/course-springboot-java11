package com.gabrielrosenbach.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielrosenbach.course.entities.Category;
import com.gabrielrosenbach.course.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findAll() {

		return categoryRepository.findAll();
	}
	
	public Category findById(Long code) {
		
		Optional<Category> category = categoryRepository.findById(code);
		
		return category.get();
	}
 }
