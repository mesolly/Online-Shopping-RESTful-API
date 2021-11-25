package com.cg.onlineshopping.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entity.CartItem;
import com.cg.onlineshopping.entity.Category;
import com.cg.onlineshopping.entity.Product;
import com.cg.onlineshopping.entity.ShoppingCart;
import com.cg.onlineshopping.entity.User;
import com.cg.onlineshopping.exception.CategoryNotFoundException;
import com.cg.onlineshopping.exception.UserNotFoundException;
import com.cg.onlineshopping.repository.ProductRepository;
import com.cg.onlineshopping.repository.ShoppingCartRepository;
import com.cg.onlineshopping.repository.UserRepository;

@Service
public class ShoppingCartService implements IShoppingCartService {
	
	@Autowired												//Dependency Injection 
	private ShoppingCartRepository cartRepo ;
	
	@Autowired												//Dependency Injection 
	private UserRepository userRepo ;
	
	@Autowired												//Dependency Injection 
	private ProductRepository prodRepo ;

	@Override
	public ShoppingCart addToCart(long custId, long prodId) throws CategoryNotFoundException , UserNotFoundException{
		
		prodRepo.findById(prodId)
				.orElseThrow(() -> new CategoryNotFoundException("Product not found::" + prodId)); //Checking if product exist or not in datasbase
		
		
		userRepo.findById(custId )
				.orElseThrow(() -> new UserNotFoundException("User not found::" + custId));	//checking whether the user is present in db or not
		
		
		
		long cartId = userRepo.findById(custId).get().getCart().getCartId();	//fetching the cartid from user table
		ShoppingCart shoppingCart = cartRepo.findById(cartId).orElse(null) ;	//fetching shopping cart from carid  
		Product p =prodRepo.getById(prodId) ;									//creating instance of a specify product
		for(CartItem item : shoppingCart.getCartItem()) {						//Fetching cartitem
			if(p.getProductId()==item.getProduct().getProductId()) {			//checking if the product is al
				item.setQuantity(item.getQuantity()+1);							//incrementing quantity if product is already in cart 
				return cartRepo.save(shoppingCart);								
			}
		}
		CartItem cartItem = new CartItem();										//creating instance of cartitem
		cartItem.setProduct(p);													//saving the product in cartitem
		long quantity = cartItem.getQuantity() ;								
		cartItem.setQuantity(1);												//setting quatity
		shoppingCart.getCartItem().add(cartItem) ;								//adding list of cartitem in shopping cart
		return cartRepo.save(shoppingCart);		

	}
	

	@Override
	public ResponseEntity<ShoppingCart> viewCart(long custId) {					//Method to view the cart																																										
		// TODO Auto-generated method stub
		long cartId = userRepo.findById(custId).get().getCart().getCartId();	//getting the cart id from user table
		ShoppingCart cart =  cartRepo.findById(cartId).orElseThrow(() -> new CategoryNotFoundException("User not found::" + cartId));
		cart.getCartItem();						//Adding Cart item to shoppingcart								
		return ResponseEntity.ok().body(cart);
	}
	
	
}
