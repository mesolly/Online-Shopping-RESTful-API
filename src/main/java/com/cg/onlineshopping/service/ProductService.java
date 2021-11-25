package com.cg.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entity.Category;
import com.cg.onlineshopping.entity.Product;
import com.cg.onlineshopping.exception.CategoryNotFoundException;
import com.cg.onlineshopping.exception.ProductNotFoundException;
import com.cg.onlineshopping.repository.CategoryRepository;
import com.cg.onlineshopping.repository.ProductRepository;

@Service
public class ProductService implements IProductService{
	
	@Autowired
	private ProductRepository prodRepo ;
	
	@Autowired
	private CategoryRepository catRepo ;

	
	@Override
	public List<Product> getAllProduct() {
		return prodRepo.findAll();
	}

	@Override
	public ResponseEntity<Product> addProduct(Product product,Long catId) throws CategoryNotFoundException{
		Category category = catRepo.findById(catId).orElseThrow(() -> new CategoryNotFoundException("Catogery not found::" + catId));
		product.assginCategort(category);
		//product.setCategory(catRepo.findById(catId).get());
		prodRepo.save(product);
		return ResponseEntity.ok().body(product);
		
		
	}

	@Override
	public ResponseEntity<Product> getProductById(Long prodId) throws ProductNotFoundException {    //This method will throw exception
		Product product =  prodRepo.findById(prodId)
				.orElseThrow(() -> new CategoryNotFoundException("Product not found::" + prodId));
		return ResponseEntity.ok().body(product);
	}
	
	
	@Override
	public ResponseEntity<Product> updateProduct(Product product, Long prodId) throws ProductNotFoundException{ //This method will throw  exception
		Product updateProduct = prodRepo.findById(prodId).orElseThrow(() -> new CategoryNotFoundException("Product not found::" + prodId));
		
		updateProduct.setName(product.getName());
		updateProduct.setDescription(product.getDescription());
		updateProduct.setPrice(product.getPrice());
		updateProduct.setImageFileName(product.getImageFileName());
		updateProduct.setCategory(product.getCategory());
		
		prodRepo.save(updateProduct);
		//return "Product Updated";
		
		return ResponseEntity.ok().body(updateProduct);
		
	}
}
