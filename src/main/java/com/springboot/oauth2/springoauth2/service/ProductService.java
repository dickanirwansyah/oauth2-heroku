package com.springboot.oauth2.springoauth2.service;

import java.util.List;

import com.springboot.oauth2.springoauth2.entity.Product;
import com.springboot.oauth2.springoauth2.model.ProductModel;

public interface ProductService {

	Product createdProduct(ProductModel product);
	Product updatedProduct(ProductModel product);
	Product findIdproduct(String idproduct);
	List<Product> listProduct();
}
