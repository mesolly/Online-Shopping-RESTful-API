package com.cg.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshopping.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem,Long>{

}
