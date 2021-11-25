package com.cg.onlineshopping.service;

import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.cg.onlineshopping.entity.CartItem;
import com.cg.onlineshopping.entity.ShoppingCart;

public interface IShoppingCartService {
	public ShoppingCart addToCart(long custId,long prodId);
	public ResponseEntity<ShoppingCart> viewCart(long custId) ;
}
