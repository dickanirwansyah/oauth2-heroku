package com.springboot.oauth2.springoauth2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.oauth2.springoauth2.dao.CategoryDao;
import com.springboot.oauth2.springoauth2.entity.Category;
import com.springboot.oauth2.springoauth2.model.CategoryModel;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<Category> listCategory() {
		return categoryDao.listCategory();
	}

	@Override
	public Category createdCategory(CategoryModel category) {
		return categoryDao.createdCategory(category);
	}

	@Override
	public Category updatedCategory(CategoryModel category) {
		return categoryDao.updatedCategory(category);
	}

	@Override
	public Category findIdcategory(String idcategory) {
		return categoryDao.findCategory(idcategory);
	}

}
