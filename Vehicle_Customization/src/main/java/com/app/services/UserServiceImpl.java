package com.app.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.repositories.UserRepository;

@Service
@Transactional 
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepo ;
	
	
}
