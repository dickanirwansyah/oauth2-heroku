package com.springboot.oauth2.springoauth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.oauth2.springoauth2.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	@Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username)")
	User findByUsernameCaseSensitive(@Param("username") String username);

	@Query
	User findByEmail(String email);
	
	@Query
	User findByemailAndActivationkey(String email, String activationkey);
	
	@Query
	User findByemailAndResetpasswordkey(String email, String resetpasswordkey);

}
