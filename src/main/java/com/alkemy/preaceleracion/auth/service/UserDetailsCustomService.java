package com.alkemy.preaceleracion.auth.service;

import java.util.Collections;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.alkemy.preaceleracion.auth.entity.UserEntity;
import com.alkemy.preaceleracion.auth.repository.UserRepository;

@Service
public class UserDetailsCustomService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> userIsPresent = userRepository.getUserByName(username);
			if(userIsPresent == null){
				throw new UsernameNotFoundException("Username or password not be found");
			}
		return new User(userIsPresent.get().getUserName(), userIsPresent.get().getPassword(), Collections.emptyList());
	}
	
}
