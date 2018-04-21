package com.springboot.oauth2.springoauth2.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "tabel_user")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String iduser;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Email
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "activated")
	private boolean activated;
	
	@Column(name = "activationkey")
	private String activationkey;
	
	@Column(name = "resetpasswordkey")
	private String resetpasswordkey;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tabel_user_role", joinColumns = 
	@JoinColumn(name = "iduser", referencedColumnName = "iduser"), inverseJoinColumns = 
	@JoinColumn(name = "idrole", referencedColumnName = "idrole"))
	private List<Role> roles = new ArrayList<>();
}
