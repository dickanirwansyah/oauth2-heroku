package com.springboot.oauth2.springoauth2.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.oauth2.springoauth2.entity.Product;
import com.springboot.oauth2.springoauth2.model.ProductModel;
import com.springboot.oauth2.springoauth2.repository.ProductRepository;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> listProduct() {
		List<Product> products = new ArrayList<>();
		for(Product product : productRepository.findAll()) {
			products.add(product);
		}
		return products;
	}

	@Override
	public Product createdProduct(ProductModel product) {
		String idproduct = product.getIdproduct();
		boolean valid = false;
		Product entityProduct = null;
		
		if(idproduct == null) {
			entityProduct = new Product();
			valid = true;
		}
		entityProduct.setName(product.getName());
		entityProduct.setPrice(product.getPrice());
		entityProduct.setQuantity(product.getQuantity());
		entityProduct.setBrand(product.getBrand());
		entityProduct.setCategory(product.getCategory());
		productRepository.save(entityProduct);
		return entityProduct;
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

}
