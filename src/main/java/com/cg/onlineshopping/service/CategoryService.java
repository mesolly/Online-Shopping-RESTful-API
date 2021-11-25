package com.cg.onlineshopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entity.Category;
import com.cg.onlineshopping.exception.CategoryNotFoundException;
import com.cg.onlineshopping.repository.CategoryRepository;

@Service
public class CategoryService implements ICategoryService {
	
	@Autowired
	private CategoryRepository catRepo ;
	
	@Override
	public Category addCategory(Category category) {
		return catRepo.save(category) ;
	}
	
	@Override
	public List<Category> getAllCategory() {
		return  catRepo.findAll();
	}

	@Override
	public ResponseEntity<Category> getCategory(Long catId) throws CategoryNotFoundException{
		//return catRepo.findById(catId).orElse(null); //This method will throw a Exception
		
		Category category = catRepo.findById(catId)
				.orElseThrow(() -> new CategoryNotFoundException("Category not found::" + catId));
		return ResponseEntity.ok().body(category);
	}
	@Override
	public ResponseEntity<Category> updateCategory(Category category, Long catId) throws CategoryNotFoundException{ //This method will throw exception
		Category categoryObj = catRepo.findById(catId)
				.orElseThrow(() -> new CategoryNotFoundException("Category not found::" + catId));

		//Category categoryObj = catRepo.findById(catId).orElse(null) ;
		categoryObj.setCategoryName(category.getCategoryName());
		categoryObj.setDescription(category.getDescription());
		catRepo.save(categoryObj);
		//return "Category Updated" ;
		
		return ResponseEntity.ok().body(categoryObj);
		
	}
	
}
