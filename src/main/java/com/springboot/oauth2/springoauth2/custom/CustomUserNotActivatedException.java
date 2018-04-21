package com.springboot.oauth2.springoauth2.custom;

import org.springframework.security.core.AuthenticationException;

public class CustomUserNotActivatedException extends AuthenticationException{

	public CustomUserNotActivatedException(String msg, Throwable t) {
		super(msg, t);
	}
	
	public CustomUserNotActivatedException(String msg) {
		super(msg);
	}

}
