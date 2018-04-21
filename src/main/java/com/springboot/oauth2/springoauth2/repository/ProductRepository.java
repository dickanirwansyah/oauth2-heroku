package com.springboot.oauth2.springoauth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.oauth2.springoauth2.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String>{

}
