package com.gabrielrosenbach.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielrosenbach.course.entities.User;
import com.gabrielrosenbach.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		
		List<User> listUsers = userService.findAll();
		
		return ResponseEntity.ok().body(listUsers);
	}
	
	@GetMapping(value = "/{code}")
	public ResponseEntity<User> findById(@PathVariable Long code) {
		
		User user = userService.findById(code);
		
		return ResponseEntity.ok().body(user);
	}
}
