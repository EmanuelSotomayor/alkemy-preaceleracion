package com.alkemy.preaceleracion.service;

import java.util.List;
import com.alkemy.preaceleracion.auth.entity.UserEntity;

public interface UserService {
	public UserEntity saveUser(UserEntity user);
	public void deleteUserById(Long id);
	public UserEntity updateUserById(Long id, UserEntity user);
	public UserEntity getUserById(Long id);
	public List<UserEntity> getAllUsers();
	public UserEntity getUserByName(String name);
}
