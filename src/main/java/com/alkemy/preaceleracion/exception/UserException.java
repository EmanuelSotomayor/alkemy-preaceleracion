package com.alkemy.preaceleracion.exception;

@SuppressWarnings("serial")
public class UserException extends RuntimeException{
	public UserException(String errorMessage){
		super(errorMessage);
	}
}
