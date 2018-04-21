package com.springboot.oauth2.springoauth2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.oauth2.springoauth2.entity.Product;
import com.springboot.oauth2.springoauth2.model.ProductModel;
import com.springboot.oauth2.springoauth2.service.ProductService;

@RestController
@RequestMapping(value = "/api/product")
public class ControllerProduct {
	
	@Autowired
	private ProductService productService;
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<Product>> listProduct(){
		return Optional.ofNullable(productService.listProduct())
				.map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
				.orElse(new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST));
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping(value = "/created")
	public ResponseEntity<Product> createdProduct(@RequestBody ProductModel product){
		return Optional.ofNullable(productService.createdProduct(product))
				.map(resultset -> new ResponseEntity<>(resultset, HttpStatus.CREATED))
				.orElse(new ResponseEntity<Product>(HttpStatus.BAD_REQUEST));
	}
}
