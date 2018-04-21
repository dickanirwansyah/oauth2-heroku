package com.springboot.oauth2.springoauth2.service;

import java.util.List;

import com.springboot.oauth2.springoauth2.entity.Category;
import com.springboot.oauth2.springoauth2.model.CategoryModel;

public interface CategoryService {
	
	List<Category> listCategory();
	Category createdCategory(CategoryModel category);
	Category updatedCategory(CategoryModel category);
	Category findIdcategory(String idcategory);
}
