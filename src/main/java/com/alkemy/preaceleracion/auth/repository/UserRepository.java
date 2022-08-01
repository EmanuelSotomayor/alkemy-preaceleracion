package com.alkemy.preaceleracion.auth.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alkemy.preaceleracion.auth.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	@Query("SELECT u FROM users u WHERE name LIKE :%name%")
	public Optional<UserEntity> getUserByName(String name);
}
