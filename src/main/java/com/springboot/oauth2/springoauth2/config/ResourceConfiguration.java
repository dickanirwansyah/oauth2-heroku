package com.springboot.oauth2.springoauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.springboot.oauth2.springoauth2.custom.CustomAuthenticationEntryPoint;

@Configuration
@EnableResourceServer
public class ResourceConfiguration extends ResourceServerConfigurerAdapter{

	@Autowired
	private CustomAuthenticationEntryPoint entryPoint;
	
	@Override
	public void configure(HttpSecurity http)throws Exception {
		
		http
		.exceptionHandling()
		.authenticationEntryPoint(entryPoint)
		.and()
		.csrf()
		.requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize"))
		.disable()
		.headers()
		.frameOptions()
		.disable()
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.NEVER)
		.and()
		.authorizeRequests()
		.antMatchers("/login").permitAll()
		.anyRequest().authenticated();
	}
}
