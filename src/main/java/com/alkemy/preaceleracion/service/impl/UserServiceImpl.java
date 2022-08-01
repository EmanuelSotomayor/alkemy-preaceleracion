package com.alkemy.preaceleracion.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.preaceleracion.auth.entity.UserEntity;
import com.alkemy.preaceleracion.auth.repository.UserRepository;
import com.alkemy.preaceleracion.exception.UserException;
import com.alkemy.preaceleracion.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserEntity saveUser(UserEntity user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(Long id) {
		Optional<UserEntity> userIsPresent = userRepository.findById(id);
		userIsPresent.orElseThrow(()-> new UserException("User doesn't exists"));
		userRepository.deleteById(id);
	}

	@Override
	public UserEntity updateUserById(Long id, UserEntity user) {
		Optional<UserEntity> userIsPresent = userRepository.findById(id);
		userIsPresent.orElseThrow(()-> new UserException("User doesn't exists"));
		userIsPresent.get().setUserName(user.getUserName());
		userIsPresent.get().setPassword(user.getPassword());
		userIsPresent.get().setEmail(user.getEmail());
		return userRepository.save(userIsPresent.get());
	}

	@Override
	public UserEntity getUserById(Long id) {
		Optional<UserEntity> userIsPresent = userRepository.findById(id);
		return userIsPresent.orElseThrow(()-> new UserException("User doesn't exists"));
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity getUserByName(String name) {
		Optional<UserEntity> userIsPresent = userRepository.getUserByName(name);
		return userIsPresent.orElseThrow(()-> new UserException("User doesn't exists"));
	}

}
