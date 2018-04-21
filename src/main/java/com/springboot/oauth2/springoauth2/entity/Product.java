package com.springboot.oauth2.springoauth2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "tabel_product")
public class Product implements Serializable{

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy="uuid2")
	private String idproduct;
	
	@Column(name = "name", nullable=false)
	private String name;
	
	@Column(name = "brand", nullable=false)
	private String brand;
	
	@Column(name = "quantity", nullable=false)
	private int quantity;
	
	@Column(name = "price", nullable=false)
	private int price;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcategory", nullable=false)
	private Category category;
}
