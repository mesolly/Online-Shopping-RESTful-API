package com.cg.onlineshopping.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlineshopping.entity.Product;
import com.cg.onlineshopping.exception.CategoryNotFoundException;
import com.cg.onlineshopping.exception.ProductNotFoundException;

public interface IProductService {
	public List<Product> getAllProduct();
	public ResponseEntity<Product> addProduct(Product product,Long catId) throws CategoryNotFoundException;
	public ResponseEntity<Product> updateProduct(Product product ,Long prodId) throws ProductNotFoundException;
	public ResponseEntity<Product> getProductById(Long prodId)  throws ProductNotFoundException;
}
