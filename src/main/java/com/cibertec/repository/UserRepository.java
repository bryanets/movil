package com.cibertec.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cibertec.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
	@Query("{'user': ?0, 'password': ?1}")
	public User login(String user, String pass);
}
