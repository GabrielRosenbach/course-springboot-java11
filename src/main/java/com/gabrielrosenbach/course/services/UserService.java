package com.gabrielrosenbach.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gabrielrosenbach.course.entities.User;
import com.gabrielrosenbach.course.repositories.UserRepository;
import com.gabrielrosenbach.course.services.exceptions.DataBaseException;
import com.gabrielrosenbach.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {

		return userRepository.findAll();
	}
	
	public User findById(Long code) {
		
		Optional<User> user = userRepository.findById(code);
		
		return user.orElseThrow(() -> new ResourceNotFoundException(code));
	}
	
	public User insert(User user) {
		
		return userRepository.save(user);
	}
	
	public void delete(Long code) {
		
		try {
			
			userRepository.deleteById(code);
		
		} catch (EmptyResultDataAccessException e) {
		
			throw new ResourceNotFoundException(code);
		} catch (DataIntegrityViolationException e) {

			throw new DataBaseException(e.getMessage());
		}
	}
	
	public User update(Long code, User user) {
		
		User entity = userRepository.getOne(code);
		
		updateData(entity, user);
		
		return userRepository.save(entity);
	}

	private void updateData(User entity, User user) {
		
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}
 }
