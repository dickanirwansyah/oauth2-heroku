package com.springboot.oauth2.springoauth2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.oauth2.springoauth2.dao.CategoryDao;
import com.springboot.oauth2.springoauth2.entity.Category;
import com.springboot.oauth2.springoauth2.model.CategoryModel;
import com.springboot.oauth2.springoauth2.service.CategoryService;

@RestController
@RequestMapping(value = "/api/category")
public class ControllerCategory {

	@Autowired
	private CategoryService categoryService;
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<Category>> listCategory(){
		return Optional.ofNullable(categoryService.listCategory())
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<List<Category>>(HttpStatus.BAD_REQUEST));
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping(value = "/created")
	public ResponseEntity<Category> createdCategory(@RequestBody CategoryModel category){
		return Optional.ofNullable(categoryService.createdCategory(category))
				.map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
				.orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping(value = "/{idcategory}")
	public ResponseEntity<Category> findId(@PathVariable String idcategory){
		return Optional.ofNullable(categoryService.findIdcategory(idcategory))
				.map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
				.orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping(value = "/updated")
	public ResponseEntity<Category> updatedCategory(@RequestBody CategoryModel category){
		return Optional.ofNullable(categoryService.updatedCategory(category))
				.map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
	}
	
}
