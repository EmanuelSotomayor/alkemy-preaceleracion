package com.alkemy.preaceleracion.auth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name", length = 20, nullable = false)
	private String userName;
	@Column(name = "password", length = 255, nullable = false)
	private String password;
	@Column(name = "email", length = 255, nullable = false)
	private String email;
	
	//private Boolean active;
	//private Set<Role> roles;
	
	//Empty constructor
	public UserEntity(){}
	
	//Parametized constructor
	public UserEntity(Long id, String userName, String password, String email){
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	
	//Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//toString()
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email + "]";
	}
}
