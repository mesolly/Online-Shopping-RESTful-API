package com.cg.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshopping.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
