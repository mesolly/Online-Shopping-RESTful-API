package com.cg.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshopping.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
	
}
