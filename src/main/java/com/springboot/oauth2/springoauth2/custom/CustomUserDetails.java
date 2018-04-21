package com.springboot.oauth2.springoauth2.custom;


import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.springboot.oauth2.springoauth2.entity.Role;
import com.springboot.oauth2.springoauth2.entity.User;
import com.springboot.oauth2.springoauth2.repository.UserRepository;

@Component
public class CustomUserDetails implements UserDetailsService{

	private final Logger logger_activity = LoggerFactory.getLogger(CustomUserDetails.class);
	
	@Autowired
	private UserRepository userRespository;
	
	@Override
	public UserDetails loadUserByUsername(final String login){
		
		logger_activity.info("proses authentication user {}", login);
		String lowerCaseLogin = login.toLowerCase();
		
		User entityUser;
		if(lowerCaseLogin.contains("@")) {
			entityUser = userRespository.findByEmail(lowerCaseLogin);
		}else {
			entityUser = userRespository.findByUsernameCaseSensitive(lowerCaseLogin);
		}
		
		if(entityUser == null) {
			throw new CustomUserNotActivatedException("User "+lowerCaseLogin+" tidak terdaftar");
		}else if(!entityUser.isActivated()) {
			throw new CustomUserNotActivatedException("User "+lowerCaseLogin+" status tidak aktive");
		}
		
		Collection<GrantedAuthority> grantedAutorities = new ArrayList<GrantedAuthority>();
		for(Role role : entityUser.getRoles()) {
			GrantedAuthority hasRole = new SimpleGrantedAuthority(role.getName());
			grantedAutorities.add(hasRole);
		}
		
		return new org.springframework.security.core.userdetails
				.User(entityUser.getUsername(), 
						entityUser.getPassword(), 
						grantedAutorities);
	}

}
