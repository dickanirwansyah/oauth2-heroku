package com.springboot.oauth2.springoauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthConfiguration extends AuthorizationServerConfigurerAdapter{

	@Autowired
	private JdbcConfiguration jdbcConfig;
	
	@Autowired
	@Qualifier("authenticationManagerBean")
	public AuthenticationManager authenticationManager;
	
	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(jdbcConfig.dataSource());
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints)throws Exception {
		endpoints
		.tokenStore(tokenStore())
		.authenticationManager(authenticationManager);
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients)throws Exception {
		clients
		.jdbc(jdbcConfig.dataSource());
	}
}
