package com.springboot.oauth2.springoauth2.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JdbcConfiguration {

	@Value("${spring.datasource.url}")
	private String dataSourceUrl;
	
	@Value("${spring.datasource.username}")
	private String datasourceUsername;
	
	@Value("${spring.datasource.password}")
	private String datasourcePassword;
	
	@Bean
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(dataSourceUrl);
		dataSource.setUsername(datasourceUsername);
		dataSource.setPassword(datasourcePassword);
		return dataSource;
	}
}
