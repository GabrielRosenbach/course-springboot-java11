package com.gabrielrosenbach.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user) {

		user = userService.insert(user);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}
	
	@DeleteMapping(value = "/{code}")
	public ResponseEntity<Void> delete(@PathVariable Long code) {

		userService.delete(code);

		return ResponseEntity.noContent().build();
	}
}
