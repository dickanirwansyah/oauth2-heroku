package com.springboot.oauth2.springoauth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.oauth2.springoauth2.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, String>{

}
