package com.springboot.oauth2.springoauth2.dao;

import java.util.List;

import com.springboot.oauth2.springoauth2.entity.Category;
import com.springboot.oauth2.springoauth2.model.CategoryModel;

public interface CategoryDao {
	
	List<Category> listCategory();
	Category createdCategory(CategoryModel category);
	Category updatedCategory(CategoryModel category);
	Category findCategory(String idcategory);
}
