package com.cg.onlineshopping.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlineshopping.entity.Category;
import com.cg.onlineshopping.exception.CategoryNotFoundException;

public interface ICategoryService {
	public List<Category> getAllCategory();
	public Category addCategory(Category category);
	public ResponseEntity<Category> getCategory(Long catId)  throws CategoryNotFoundException;
	public ResponseEntity<Category> updateCategory(Category category,Long catId) throws CategoryNotFoundException;
}
