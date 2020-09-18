package com.andre.mockapi.repository.service;

import org.springframework.stereotype.Repository;

import com.andre.mockapi.models.User;
import com.andre.mockapi.repository.UserRepository;

@Repository
public class UserService extends GenericService<User> implements UserRepository {
	
}
