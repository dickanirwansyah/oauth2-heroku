package com.springboot.oauth2.springoauth2.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.oauth2.springoauth2.entity.Category;
import com.springboot.oauth2.springoauth2.model.CategoryModel;
import com.springboot.oauth2.springoauth2.repository.CategoryRepository;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> listCategory() {
		List<Category> list = new ArrayList<>();
		for(Category category : categoryRepository.findAll()) {
			list.add(category);
		}
		return list;
	}

	@Override
	public Category createdCategory(CategoryModel category) {
		String idcategory = category.getIdcategory();
		Category entityCategory = null;
		boolean valid = false;
		
		if(idcategory == null) {
			entityCategory = new Category();
			valid = true;
		}
		entityCategory.setName(category.getName());
		entityCategory.setDescription(category.getDescription());
		categoryRepository.save(entityCategory);
		return entityCategory;
	}

	private Category getId(String idcategory) {
		return categoryRepository.findOne(idcategory);
	}
	
	@Override
	public Category updatedCategory(CategoryModel category) {
		String idcategory = category.getIdcategory();
		Category entityCategory = null;
		boolean valid = false;
		if(idcategory != null) {
			entityCategory = this.getId(idcategory);
			valid = true;
		}
		
		entityCategory.setIdcategory(category.getIdcategory());
		entityCategory.setName(category.getName());
		entityCategory.setDescription(category.getDescription());
		categoryRepository.save(entityCategory);
		return entityCategory;
	}

	@Override
	public Category findCategory(String idcategory) {
		return categoryRepository.findOne(idcategory);
	}

}
