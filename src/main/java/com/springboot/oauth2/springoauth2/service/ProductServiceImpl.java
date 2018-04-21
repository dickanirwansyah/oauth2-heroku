package com.springboot.oauth2.springoauth2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.oauth2.springoauth2.dao.ProductDao;
import com.springboot.oauth2.springoauth2.entity.Product;
import com.springboot.oauth2.springoauth2.model.ProductModel;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public Product createdProduct(ProductModel product) {
		return productDao.createdProduct(product);
	}

	@Override
	public Product updatedProduct(ProductModel product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findIdproduct(String idproduct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> listProduct() {
		return productDao.listProduct();
	}

}
