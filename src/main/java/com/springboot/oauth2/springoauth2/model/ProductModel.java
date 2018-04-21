package com.springboot.oauth2.springoauth2.model;

import com.springboot.oauth2.springoauth2.entity.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductModel {
	
	private String idproduct;
	private String name;
	private String brand;
	private int quantity;
	private int price;
	private Category category;
}
