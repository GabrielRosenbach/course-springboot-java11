package com.gabrielrosenbach.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielrosenbach.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
