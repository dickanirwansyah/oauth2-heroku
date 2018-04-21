package com.springboot.oauth2.springoauth2.custom;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint{

	private final Logger logger_activity = LoggerFactory.getLogger(CustomAuthenticationEntryPoint.class);
	
	@Override
	public void commence(HttpServletRequest request, 
						 HttpServletResponse response, 
						 AuthenticationException auth)
			throws IOException, ServletException {
		
		logger_activity.info("proses authentication entry point called. Rejecting access");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied");
		
	}

}
