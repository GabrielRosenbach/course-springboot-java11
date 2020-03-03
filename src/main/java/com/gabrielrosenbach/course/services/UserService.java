package com.gabrielrosenbach.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielrosenbach.course.entities.User;
import com.gabrielrosenbach.course.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {

		return userRepository.findAll();
	}
	
	public User findById(Long code) {
		
		Optional<User> user = userRepository.findById(code);
		
		return user.get();
	}
	
	public User insert(User user) {
		
		return userRepository.save(user);
	}
	
	public void delete(Long code) {
		
		userRepository.deleteById(code);
	}
 }
